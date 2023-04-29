/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：chapter29/QQ2006/src/main/kotlin/com/a51work6/qq/server/Server.kt
package com.zhijieketang.server

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.json
import java.net.DatagramPacket
import java.net.DatagramSocket

// 操作命令代码
const val COMMAND_LOGIN = 1 // 登录命令
const val COMMAND_LOGOUT = 2 // 下线命令
const val COMMAND_SENDMSG = 3 // 发消息命令
const val COMMAND_REFRESH = 4 // 刷新好友列表命令

// 服务器端口
const val SERVER_PORT = 7788

fun main() {

    println("服务器启动, 监听自己的端口$SERVER_PORT...")
    //JSON解析器
    val parser = Parser.default()
    // 创建数据访问对象
    val dao = UserDAO()
    // 所有已经登录的客户端信息
    val clientList = mutableListOf<ClientInfo>()

    // 创建DatagramSocket对象，监听自己的端口7788
    DatagramSocket(SERVER_PORT).use { socket ->

        //主协程循环
        while (true) {

            // 准备一个缓冲区
            var buffer = ByteArray(1024)
            // 创建数据报包对象，用来接收数据
            var packet = DatagramPacket(buffer, buffer.size)
            // 接收数据报包
            socket.receive(packet)
            // 接收的字符串
            val jsonString = String(buffer, 0, packet.length)
            // 从客户端传来的数据包中得到客户端地址
            val address = packet.address
            // 从客户端传来的数据包中得到客户端端口号
            val port = packet.port
            println("服务器接收客户端，消息：$jsonString")

            var jsonObject = parser.parse(StringBuilder(jsonString)) as JsonObject
            //取出客户端传递过来的操作命令
            val cmd = jsonObject.int("command")

            when (cmd) {
                COMMAND_LOGIN -> {// 用户登录过程

                    val userId = jsonObject["user_id"] as String
                    val userPwd = jsonObject["user_pwd"] as String
                    // 通过用户Id查询用户信息
                    val user = dao.findById(userId)

                    // 判断客户端发送过来的密码与数据库的密码是否一致
                    if (user != null && userPwd == user["user_pwd"]) {
                        // 通过user对象创建JsonObject对象，其中user是Map类型
                        val sendJsonObj = JsonObject(user)
                        // 添加返回结果信息 result:0键值对，"0"表示成功，"-1"表示失败
                        sendJsonObj["result"] = "0"

                        // 创建客户端信息对象cInfo保存客户端的用户Id和地址
                        val cInfo = ClientInfo(port, address, userId)

                        // 如果客户端端列表clientList中没有该客户端信息，则添加该客户端数据
                        if (clientList.none { it.userId == userId }) {
                            clientList.add(cInfo)
                        }

                        // 根据客用户Id查询他的好友列表
                        val friends = dao.findFriends(userId)!!.map {
                            // 将好友转换为可变Map对象
                            val friend = it.toMutableMap()
                            // 取出好友的用户Id
                            val fid = it["user_id"]
                            // 添加好友状态 "1"在线 "0"离线
                            if (clientList.any { it.userId == fid })
                            // 好友在clientList集合中存在时说明好友【在线】，否【离线】
                                friend["online"] = "1" else friend["online"] = "0"
                            //返回数据
                            friend
                        }.map {
                            JsonObject(it)
                        }

                        sendJsonObj["friends"] = json {
                            array(friends)
                        }
                        println("服务器发送用户成功，消息：${sendJsonObj.toJsonString()}")
                        // 创建DatagramPacket对象，用于向客户端发送数据
                        buffer = sendJsonObj.toJsonString().toByteArray()
                        packet = DatagramPacket(buffer, buffer.size, address, port)
                        socket.send(packet)
                    } else {
                        // 发送失败消息
                        val jsonObj = json {
                            obj("result" to "-1")
                        }
                        println("服务器给用户登录失败，消息：${jsonObj.toJsonString()}")
                        buffer = jsonObj.toJsonString().toByteArray()
                        packet = DatagramPacket(buffer, buffer.size, address, port)
                        // 向请求登录的客户端发送数据
                        socket.send(packet)
                    }
                }
                COMMAND_SENDMSG -> {// 用户发送消息
                    // 获得好友Id
                    val friendUserId = jsonObject["receive_user_id"] as String
                    // 向客户端发送数据
                    clientList.filter {
                        // 找到好友过滤条件
                        it.userId == friendUserId
                    }.forEach {
                        println("服务器转发聊天，消息：${jsonObject.toJsonString()}")
                        // 创建DatagramPacket对象，用于向客户端发送数据
                        buffer = jsonObject.toJsonString().toByteArray()
                        packet = DatagramPacket(buffer, buffer.size, it.address, it.port)
                        // 发送消息给好友
                        socket.send(packet)
                    }
                }
                COMMAND_LOGOUT -> {// 用户发送下线命令
                    // 获得用户Id
                    val userId = jsonObject["user_id"] as String
                    val clientInfo = clientList.first {
                        it.userId == userId
                    }
                    // 从clientList集合中删除用户
                    clientList.remove(clientInfo)
                }
            }

            ///刷新用户列表
            //如果clientList中没有元素时跳到下次循环
            if (clientList.isEmpty()) continue

            val jsonObj = JsonObject()
            jsonObj["command"] = COMMAND_REFRESH

            val userIdList = clientList.map {
                it.userId
            }
            jsonObj["OnlineUserList"] = json {
                array(userIdList)
            }
            println("服务器向客户端发送消息，刷新用户列表：${jsonObj.toJsonString()}")
            // 向客户端发送数据刷新用户列表
            clientList.forEach {
                buffer = jsonObj.toJsonString().toByteArray()
                packet = DatagramPacket(buffer, buffer.size, it.address, it.port)
                socket.send(packet)
            }
        }
    }
}



