/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/HelloProj/module1/src/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.util.*

fun main() {
    val now = Date()
    val person = Person("Tony", now, 18)
    println(person.name)
    println(person.age)
    println(person.birthDate)//不能访问birthDate属性
    person.display()

}
