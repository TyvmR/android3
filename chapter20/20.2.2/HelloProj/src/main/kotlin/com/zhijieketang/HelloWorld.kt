/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件： HelloProj/src/main/java/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.util.*

fun main() {
    val person = Person()
    val date = person.birthDate
    println("date = $date")    //null
    val date1: Date? = person.birthDate
    println("date1 = $date1")    //null
    val date2: Date = person.birthDate    //抛出异常
    println("date2 = $date2")

}