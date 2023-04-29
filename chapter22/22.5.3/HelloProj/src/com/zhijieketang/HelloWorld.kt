/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.net.URL

fun main() {
    // Web网址
    val url = "http://www.sina.com.cn/"
    URL(url).openStream().use { input ->
        input.bufferedReader().forEachLine { println(it) }
    }
}