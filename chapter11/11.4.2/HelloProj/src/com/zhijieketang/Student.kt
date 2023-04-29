/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/com/zhijieketang/Student.kt
package com.zhijieketang

class Student(name: String, age: Int, private val school: String) : Person(name, age) {

    override fun toString(): String {
        return ("Student [school=$school,name=$name,age=$age]")
    }
}
