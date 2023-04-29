/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//基本数据类型扩展
fun Double.interestBy(interestRate: Double): Double {
    return this * interestRate
}

//自定义账户类
class Account {
    var amount: Double = 0.0    //账户金额
    var owner: String = ""      //账户名
}

//账户类函数扩展
fun Account.interestBy(interestRate: Double): Double {
    return this.amount * interestRate
}

fun main() {

    val interest1 = 10_000.00.interestBy(0.0668)
    println("利息1: $interest1")

    val account = Account()
    val interest2 = account.interestBy(0.0668)
    println("利息2: $interest2")
}