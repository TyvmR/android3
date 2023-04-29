/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/UploadServer.kt
package com.zhijieketang

import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.ServerSocket

fun main() {
    println("服务器端运行...")
    ServerSocket(8080).use { server ->
        server.accept().use { socket ->
            BufferedInputStream(socket.getInputStream()).use { sin ->
                FileOutputStream("./TestDir/subDir/coco2dxcplus.jpg").use { fout ->
                    sin.copyTo(fout)
                    println("接收完成！")
                }
            }
        }
    }
}