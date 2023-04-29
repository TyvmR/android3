/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//Kotlin代码文件：HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun main() {

    try {
        InputStreamReader(System.`in`).use { ir ->
            BufferedReader(ir).use { reader ->
                // 从键盘接收了一个字符串的输入
                val command = reader.readLine()
                println(command)
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}