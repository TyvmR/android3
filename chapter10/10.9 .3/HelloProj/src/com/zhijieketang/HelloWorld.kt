/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    // 返回一个包含全部枚举常量的数组
    val allValues = WeekDays.values()
    // 遍历枚举常量数值
    for (value in allValues) {
        println("${value.ordinal} - $value")
    }

    // 创建WeekDays对象
    val day1 = WeekDays.FRIDAY
    val day2 = WeekDays.valueOf("FRIDAY")

    println(day1 === WeekDays.FRIDAY)//true
    println(day1 == WeekDays.FRIDAY)//true
    println(day1 === day2)//true

}