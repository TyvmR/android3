/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

private fun calculate(opr: Char): (Int, Int) -> Int {

    return when (opr) {
        '+' -> { a: Int, b: Int -> a + b }
        '-' -> { a: Int, b: Int -> a - b }
        '*' -> { a: Int, b: Int -> a * b }
        else -> { a: Int, b: Int -> a / b }
    }
}

//fun calculate(opr: Char): (Int, Int) -> Int = when (opr) {
//    '+' -> { a: Int, b: Int -> a + b }
//     '-' -> { a: Int, b: Int -> a - b }
//     '*' -> { a: Int, b: Int -> a * b }
//    else -> { a: Int, b: Int -> a / b }
//}

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