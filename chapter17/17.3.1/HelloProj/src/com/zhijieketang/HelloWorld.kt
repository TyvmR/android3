/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val date = readDate()
    println("日期  = $date")
}

// 解析日期
private fun readDate(): Date? {

    try {
        val str = "201A-18-18" //"201A-18-18"
        val df = SimpleDateFormat("yyyy-MM-dd")
        // 从字符串中解析日期
        return df.parse(str)
    } catch (e: ParseException) {
        println("处理ParseException...")
        e.printStackTrace()
    }

    return null
}
