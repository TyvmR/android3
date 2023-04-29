/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {
    // day工作日变量
    val day = WeekDays.FRIDAY
    println(day)
    when (day) {
        WeekDays.MONDAY -> println("星期一")
        WeekDays.TUESDAY -> println("星期二")
        WeekDays.WEDNESDAY -> println("星期三")
        WeekDays.THURSDAY -> println("星期四")
        else //case FRIDAY:
        -> println("星期五")
    }
}