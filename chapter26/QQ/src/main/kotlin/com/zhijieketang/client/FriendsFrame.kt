/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：QQ/src/main/kotlin/com/zhijieketang/client/FriendsFrame.kt
package com.zhijieketang.client

import com.beust.klaxon.JsonObject
import com.beust.klaxon.json
import kotlinx.coroutines.*
import java.awt.BorderLayout
import java.awt.Color
import java.awt.GridLayout
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.net.DatagramPacket
import java.net.InetAddress
import javax.swing.*

class FriendsFrame(private val user: Map<String, Any>) : JFrame() {

    // 好友列表
    private val friends: List<Map<String, String>>

    // 好友标签控件列表
    private val lblFriendList = mutableListOf<JLabel>()

    // 获得当前屏幕的宽
    private val screenWidth = Toolkit.getDefaultToolkit().screenSize.getWidth()

    // 登录窗口宽和高
    private val frameWidth = 260
    private val frameHeight = 600

    //声明一个协程引用
    private var job: Job? = null

    // 协程运行状态
    private var isRunning = true

    init {
        /// 初始化当前Frame
        title = "QQ2006"
        setBounds(screenWidth.toInt() - 300, 10, frameWidth, frameHeight)

        iconImage = Toolkit.getDefaultToolkit().getImage(("images/QQ.png"))

        // 设置布局
        val borderLayout = contentPane.layout as BorderLayout
        borderLayout.vgap = 5

        /// 初始化用户列表
        friends = user["friends"] as List<Map<String, String>>
        val userId = user["user_id"] as String
        val userName = user["user_name"] as String
        val userIcon = user["user_icon"] as String

        with(JLabel(userName)) {
            horizontalAlignment = SwingConstants.CENTER
            val iconFile = "images/$userIcon.jpg"
            icon = ImageIcon(iconFile)
            contentPane.add(this, BorderLayout.NORTH)
        }

        val panel1 = JPanel()
        panel1.layout = BorderLayout(0, 0)

        with(JScrollPane()) {
            border = BorderFactory.createLineBorder(Color.blue, 1)
            setViewportView(panel1)
            contentPane.add(this, BorderLayout.CENTER)
        }

        with(JLabel("我的好友")) {
            horizontalAlignment = SwingConstants.CENTER
            panel1.add(this, BorderLayout.NORTH)
        }

        // 好友列表面板
        val friendListPanel = JPanel()
        friendListPanel.layout = GridLayout(50, 0, 0, 5)
        panel1.add(friendListPanel)

        // 初始化好友列表
        friends.forEach { friend ->

            val friendUserId = friend["user_id"]
            val friendUserName = friend["user_name"]
            val friendUserIcon = friend["user_icon"]
            // 获得好友在线状态
            val friendUserOnline = friend["online"]

            val lblFriend = JLabel(friendUserName).apply {

                toolTipText = friendUserId
                val friendIconFile = "images/$friendUserIcon.jpg"
                icon = ImageIcon(friendIconFile)
                // 在线设置可用，离线设置不可用
                isEnabled = friendUserOnline != "0"

                // 添加到列表集合
                lblFriendList.add(this)
                // 添加到面板
                friendListPanel.add(this)
            }

            lblFriend.addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent) {
                    // 用户图标双击鼠标时显示对话框
                    if (e.clickCount == 2) {
                        stopCoroutine()
                        ChatFrame(this@FriendsFrame, user, friend).isVisible = true
                    }
                }
            })
        }

        // 注册窗口事件
        addWindowListener(object : WindowAdapter() {
            // 单击窗口关闭按钮时调用
            override fun windowClosing(e: WindowEvent) {
                // 当前用户下线
                val jsonObj = json {
                    obj("command" to COMMAND_LOGOUT, "user_id" to userId)
                }

                val b = jsonObj.toJsonString().toByteArray()
                val address = InetAddress.getByName(SERVER_IP)
                // 创建DatagramPacket对象
                val packet = DatagramPacket(b, b.size, address, SERVER_PORT)
                // 发送
                socket.send(packet)
                // 关闭Socket
                socket.close()
                // 退出系统
                System.exit(0)
            }
        })
        println("启动接收消息子协程")
        resetCoroutine()
    }

    // 刷新好友列表
    fun refreshFriendList(userIdList: List<String>) {
        // 初始化好友列表
        lblFriendList.forEach {
            val friendId = it.toolTipText!!
            //在线用户列表userIdList中存在friendId
            it.isEnabled = userIdList.contains(friendId)
        }
    }

    // 重新启动接收消息子协程
    fun resetCoroutine() = runBlocking<Unit> {
        isRunning = true
        // 创建并启动协程
        job = GlobalScope.launch {
            run()
        }
    }

    // 停止接收消息子协程
    fun stopCoroutine() = runBlocking<Unit> {
        isRunning = false
        //取消协程
        job?.cancelAndJoin()
    }

    //协程体执行的挂起函数
    suspend fun run() {
        // 准备一个缓冲区
        val buffer = ByteArray(1024)
        while (isRunning) {

            val address = InetAddress.getByName(SERVER_IP)
            /* 接收数据报 */
            val packet = DatagramPacket(buffer, buffer.size, address, SERVER_PORT)
            try {
                // 开始接收
                socket.receive(packet)

                val stringObj = String(buffer, 0, packet.length)
                println("客户端收到的消息：$stringObj")

                val jsonObj = parser.parse(StringBuilder(stringObj)) as JsonObject

                val cmd = jsonObj.int("command")

                if (cmd != null && cmd == COMMAND_REFRESH) {
                    val userIdList = jsonObj["OnlineUserList"] as List<String>
                    // 刷新好友列表
                    refreshFriendList(userIdList)
                }
                delay(100L)
            } catch (e: Exception) {
                //捕获超时异常，继续
            }
        }
    }

}
