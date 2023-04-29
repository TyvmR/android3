/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：HelloProj/src/main/kotlin/com/zhijieketang/ExceptionDemo.kt
package com.zhijieketang;

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

// 解析日期
@Throws(ParseException::class)
fun readDate(): Date? {
    val str = "201A-18-18" //非法格式日期
    val df = SimpleDateFormat("yyyy-MM-dd")
    // 从字符串中解析日期
    return df.parse(str)
}