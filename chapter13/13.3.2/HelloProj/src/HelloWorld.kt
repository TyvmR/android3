/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//打印计算结果函数
fun calculatePrint(
    n1: Int,
    n2: Int,
    opr: Char,
    funN: (Int, Int) -> Int
) {//函数类型
    println("$n1 $opr $n2 = ${funN(n1, n2)}")
}

fun main() {
    calculatePrint(10, 5, '+', { a: Int, b: Int -> a + b })
    calculatePrint(10, 5, '-', funN = { a: Int, b: Int -> a - b })
}