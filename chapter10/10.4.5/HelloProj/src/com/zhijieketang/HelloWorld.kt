/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

// 员工类
open class Employee {

    var no: Int = 0             // 员工编号属性
    var firstName: String = "Tony"
    var lastName: String = "Guan"

    val fullName: String by lazy {
        "$firstName.$lastName"
    }

    lateinit var dept: Department

}

// 部门类
class Department {
    var no: Int = 0            // 部门编号属性
    var name: String = ""     // 部门名称属性
}

// 主函数
fun main() {

    val emp = Employee()
    println(emp.fullName)//Tony.Guan

    val dept = Department()
    dept.no = 20

    emp.dept = dept
    println(emp.dept)
}