/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：代码/HelloProj/module1/src/com/zhijieketang/Person.kt
package com.zhijieketang

import java.util.*

class Person(
    val name: String,// 名字
    private val birthDate: Date,// 出生日期
    internal val age: Int
)// 年龄
{
    internal fun display() {
        println("[name:$name, birthDate:$birthDate, age:$age]")
    }
}
