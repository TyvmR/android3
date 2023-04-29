/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/UploadClient.kt
package com.zhijieketang

import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress


fun main() {
    println("客户端运行...")

    DatagramSocket().use { socket ->
        FileInputStream("./TestDir/coco2dxcplus.jpg").use { fin ->
            BufferedInputStream(fin).use { input ->

                // 创建远程主机IP地址对象
                val address = InetAddress.getByName("localhost")

                // 准备一个缓冲区
                val buffer = ByteArray(1024)
                // 首次从文件流中读取数据
                var len = input.read(buffer)

                while (len != -1) {
                    // 创建数据报包对象
                    val packet = DatagramPacket(buffer, len, address, 8080)
                    // 发送数据报包
                    socket.send(packet)
                    // 再次从文件流中读取数据
                    len = input.read(buffer)
                }
                // 创建数据报对象
                val packet = DatagramPacket("bye".toByteArray(), 3, address, 8080)
                // 发送结束标志
                socket.send(packet)
                println("上传完成！")
            }
        }
    }
}