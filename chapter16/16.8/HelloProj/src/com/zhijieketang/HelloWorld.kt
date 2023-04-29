/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//求n的阶乘
fun factorial(n: Int) = IntArray(n) { it + 1 }
    .reduce { acc, i -> acc * i }

fun main() {

    println("1! = ${factorial(1)}") //输出：1! = 1
    println("2! = ${factorial(2)}") //输出：2! = 1
    println("5! = ${factorial(5)}") //输出：5! = 120
    println("10! = ${factorial(10)}") //输出：10! = 3628800
}

