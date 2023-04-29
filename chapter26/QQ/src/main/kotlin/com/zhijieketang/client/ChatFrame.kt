/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：QQ/src/main/kotlin/com/zhijieketang/client/ChatFrame.kt
package com.zhijieketang.client

import com.beust.klaxon.JsonObject
import kotlinx.coroutines.*
import java.awt.Color
import java.awt.Toolkit
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.net.DatagramPacket
import java.net.InetAddress
import java.text.SimpleDateFormat
import java.util.*
import javax.swing.*

class ChatFrame(// 好友列表Frame
    private val friendsFrame: FriendsFrame,
    user: Map<String, Any>,
    friend: Map<String, String>
) : JFrame() {

    // 当前用户Id
    private val userId = user["user_id"] as String

    // 聊天好友用户Id
    private val friendUserId: String

    // 聊天好友用户名
    private val friendUserName: String

    // 获得当前屏幕的高和宽
    private val screenHeight = Toolkit.getDefaultToolkit().screenSize.getHeight()
    private val screenWidth = Toolkit.getDefaultToolkit().screenSize.getWidth()

    // 登录窗口宽和高
    private val frameWidth = 360
    private val frameHeight = 330

    // 查看消息文本区
    private val txtMainInfo = JTextArea()

    // 发送消息文本区
    private val txtInfo = JTextArea()

    // 消息日志
    private val infoLog = StringBuffer()

    // 日期格式化
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    //声明一个协程引用
    private var job: Job? = null

    // 协程运行状态
    private var isRunning = true

    // 查看消息面板
    private val panLine1: JPanel
        get() {
            txtMainInfo.isEditable = false

            val panLine1 = JPanel().apply {
                layout = null
                setBounds(5, 5, 330, 210)
                border = BorderFactory.createLineBorder(Color.blue, 1)
            }
            with(JScrollPane()) {
                setBounds(5, 5, 320, 200)
                panLine1.add(this)
                setViewportView(txtMainInfo)
            }

            return panLine1
        }

    // 发送消息面板
    private val panLine2: JPanel
        get() {
            val panLine2 = JPanel().apply {
                layout = null
                setBounds(5, 220, 330, 50)
                border = BorderFactory.createLineBorder(Color.blue, 1)
                add(sendButton)
            }
            with(JScrollPane()) {
                setBounds(5, 5, 222, 40)
                panLine2.add(this)
                setViewportView(txtInfo)
            }

            return panLine2
        }

    private val sendButton: JButton
        get() {
            val button = JButton("发送").apply {
                setBounds(232, 10, 90, 30)
            }
            button.addActionListener {
                sendMessage()
                txtInfo.text = ""
            }
            return button
        }

    init {

        val userIcon = user["user_icon"]!!
        friendUserId = friend["user_id"]!!
        friendUserName = friend["user_name"]!!

        /// 初始化当前Frame
        val iconFile = "images/$userIcon.jpg"
        iconImage = Toolkit.getDefaultToolkit().getImage(iconFile)
        title = "与${friendUserName}聊天中..."
        isResizable = false
        layout = null

        // 设置Frame大小
        setSize(frameWidth, frameHeight)
        // 计算Frame位于屏幕中心的坐标
        val x = (screenWidth - frameWidth).toInt() / 2
        val y = (screenHeight - frameHeight).toInt() / 2
        // 设置Frame位于屏幕中心
        setLocation(x, y)

        // 初始化查看消息面板
        contentPane.add(panLine1)
        // 初始化发送消息面板
        contentPane.add(panLine2)

        // 注册窗口事件
        addWindowListener(object : WindowAdapter() {
            // 单击窗口关闭按钮时调用
            override fun windowClosing(e: WindowEvent) {
                //停止协程
                stopCoroutine()
                isVisible = false
                // 重启好友列表协程
                friendsFrame.resetCoroutine()
            }
        })
        // 启动接收消息子协程
        resetCoroutine()
    }

    private fun sendMessage() {

        if (txtInfo.text != "") {

            // 获得当前时间，并格式化
            val date = dateFormat.format(Date())

            val info = "#$date#\n您对${friendUserName}说：${txtInfo.text}"
            infoLog.append(info).append('\n')
            txtMainInfo.text = infoLog.toString()

            val jsonObj = JsonObject()
            jsonObj["receive_user_id"] = friendUserId
            jsonObj["user_id"] = userId
            jsonObj["message"] = txtInfo.text
            jsonObj["command"] = COMMAND_SENDMSG

            val address = InetAddress.getByName(SERVER_IP)
            // 发送数据报
            val buffer = jsonObj.toJsonString().toByteArray()
            val packet = DatagramPacket(buffer, buffer.size, address, SERVER_PORT)
            socket.send(packet)
        }
    }

    // 重新启动接收消息子协程
    fun resetCoroutine() = runBlocking<Unit> {
        isRunning = true
        // 创建协程
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
                // 打印接收的数据
                println("从服务器接收的数据：$stringObj")

                val jsonObj = parser.parse(StringBuilder(stringObj)) as JsonObject

                val cmd = jsonObj.int("command")
                //command不等于空值时候执行，不等于空值或是
                if (cmd != null && cmd == COMMAND_REFRESH) {
                    // 获得好友列表
                    val userIdList = jsonObj["OnlineUserList"] as List<String>
                    // 刷新好友列表
//                    friendsFrame.refreshFriendList(userIdList)
                } else {
                    // 获得当前时间，并格式化
                    val date = dateFormat.format(Date())
                    val message = jsonObj.string("message")
                    if (message != null) {
                        val info = "#$date#\n${friendUserName}对您说：$message"
                        infoLog.append(info).append('\n')

                        txtMainInfo.text = infoLog.toString()
                        txtMainInfo.caretPosition = txtMainInfo.document.length
                    }
                }
                delay(100L)
            } catch (e: Exception) {
                //捕获超时异常，继续
            }
        }
    }
}