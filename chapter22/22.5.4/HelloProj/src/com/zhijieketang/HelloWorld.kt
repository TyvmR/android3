/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang


import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

// Web服务网址
private val urlString = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png"

fun main() {
    var conn: HttpURLConnection? = null
    try {
        conn = URL(urlString).openConnection() as HttpURLConnection
        conn.connect()
        conn.inputStream.use { input ->
            BufferedOutputStream(FileOutputStream("./download.png")).use { output ->
                input.copyTo(output)
            }
        }
        println("下载成功")
    } catch (e: Exception) {
        println("下载失败")
    } finally {
        conn?.disconnect()
    }
}