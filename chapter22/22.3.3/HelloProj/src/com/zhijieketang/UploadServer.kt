/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/UploadServer.kt
package com.zhijieketang

import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket

fun main() {

    println("服务器端运行...")

    DatagramSocket(8080).use { socket ->
        FileOutputStream("./TestDir/subDir/coco2dxcplus.jpg").use { fout ->
            BufferedOutputStream(fout).use { out ->

                // 准备一个缓冲区
                val buffer = ByteArray(1024)

                //循环接收数据报包
                while (true) {

                    // 创建数据报包对象，用来接收数据
                    val packet = DatagramPacket(buffer, buffer.size)
                    // 接收数据报包
                    socket.receive(packet)
                    // 接收数据长度
                    val len = packet.length

                    if (len == 3) {
                        // 获得结束标志
                        val flag = String(buffer, 0, 3)
                        // 判断结束标志，如果是bye结束接收
                        if (flag == "bye") {
                            break
                        }
                    }
                    // 写入数据到文件输出流
                    out.write(buffer, 0, len)
                }
                println("接收完成！")
            }
        }
    }
}