/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun calculate(opr: Char): (Int, Int) -> Int {

    //加法函数
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    //减法函数
    fun sub(a: Int, b: Int): Int {
        return a - b
    }

    val result: (Int, Int) -> Int =
        when (opr) {
            '+' -> ::add
            '-' -> ::sub
            '*' -> {
                //乘法匿名函数
                fun(a: Int, b: Int): Int {
                    return (a * b)
                }
            }
            else -> { a, b -> (a / b) } //除法Lambda表达式
        }
    return result
}

fun main() {
    val f1 = calculate('+')
    println(f1(10, 5))  //调用f1变量
    val f2 = calculate('-')
    println(f2(10, 5))
    val f3 = calculate('*')
    println(f3(10, 5))
    val f4 = calculate('/')
    println(f4(10, 5))
}