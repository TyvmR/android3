/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

// 员工类
class Employee {

    var no: Int = 0             // 员工编号属性
    var job: String? = null     // 工作属性
    var firstName: String = "Tony"
    var lastName: String = "Guan"
    var fullName: String
        get() {
            return "$firstName.$lastName"
        }
        set(value) {
            val name = value.split(".")
            firstName = name[0]
            lastName = name[1]
        }

    var salary: Double = 0.0    // 薪资属性
        set(value) {
            if (value >= 0.0) field = value
        }
    lateinit var dept: Department  // 所在部门属性
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
    emp.fullName = "Tom.Guan"
    println(emp.fullName)//Tom.Guan

    emp.salary = -10.0  //不接收负值
    println(emp.salary)//0.0
    emp.salary = 10.0
    println(emp.salary)//10.0

    emp.dept = Department()
    println(emp.dept)

}