/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//定义中缀函数interestBy
infix fun Double.interestBy(interestRate: Double): Double {
    return this * interestRate
}

// 部门类
class Department {
    var no: Int = 10      // 部门编号属性

    //定义中缀函数rp
    infix fun rp(times: Int) {
        repeat(times) {
            println(no)
        }
    }
}

fun main() {

    //函数调用
    val interest1 = 10_000.00.interestBy(0.0668)
    println("利息1: $interest1")

    //中缀运算符interestBy
    val interest2 = 10_000.00 interestBy 0.0668
    println("利息1: $interest2")

    val dept = Department()
    dept rp 3 //中缀运算符rp
}