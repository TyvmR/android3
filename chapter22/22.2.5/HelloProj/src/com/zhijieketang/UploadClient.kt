/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/UploadClient.kt
package com.zhijieketang

import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.net.Socket

fun main() {
    println("客户端运行...")
    Socket("127.0.0.1", 8080).use { socket ->
        BufferedOutputStream(socket.getOutputStream()).use { sout ->
            FileInputStream("./TestDir/coco2dxcplus.jpg").use { fin ->
                fin.copyTo(sout)
                println("上传成功！")
            }
        }
    }
}