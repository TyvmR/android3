/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import kotlin.properties.Delegates

// 部门类
class Department {
    var no: Int = 0            // 部门编号属性
    var name: String by Delegates.observable("<无>") { p, oldValue, newValue ->

        println("$oldValue -> $newValue")
    }
}

// 员工类
open class Employee {

    var no: Int = 0             // 员工编号属性
    var firstName: String = "Tony"
    var lastName: String = "Guan"

    val fullName: String by lazy {
        "$firstName.$lastName"
    }

    lateinit var dept: Department  // 所在部门属性

}

fun main() {

    val dept = Department()
    dept.no = 20
    dept.name = "技术部" //<无> -> 技术部
    dept.name = "市场部" //技术部 -> 市场部

}
