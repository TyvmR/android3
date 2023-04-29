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

fun main() {

    val df = SimpleDateFormat("yyyy-MM-dd")
    val date = try {// 解析日期
        df.parse("201A-18-18")
    } catch (e: ParseException) {
        null
    }
    println("日期  = $date")
}
