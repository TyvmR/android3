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

//------1. 参数类型推导简化--------
private fun calculate(opr: Char): (Int, Int) -> Int = when (opr) {
    '+' -> { a, b -> a + b }
    '-' -> { a, b -> a - b }
    '*' -> { a, b -> a * b }
    else -> { a, b -> a / b }
}

//--------2. 使用尾随Lambda表达式----
fun calculatePrint1(funN: (Int, Int) -> Int) {//定义一个函数参数是函数类型
    //使用funN参数
    println("${funN(10, 5)}")
}

//--------3. 省略参数声明----------
fun revreseAndPrint(str: String, funN: (String) -> String) {
    val result = funN(str)
    println(result)
}

fun main() {

    //--------2. 使用尾随Lambda表达式----
    //调用calculatePrint
    calculatePrint(10, 5, '+', { a, b -> a + b })//标准形式
    calculatePrint(10, 5, '-') { a, b -> a - b }//尾随Lambda表达式形式

    calculatePrint1({ a, b -> a + b })//标准形式
    calculatePrint1() { a, b -> a + b }//尾随Lambda表达式形式
    calculatePrint1 { a, b -> a + b }//尾随Lambda表达式，如果只有没有参数可省略括号

    //--------3. 省略参数名----------
    revreseAndPrint("hello", { s -> s.reversed() })//标准形式
    revreseAndPrint("hello", { it.reversed() })//省略参数，使用隐式参数it

    val result1 = { a: Int -> println(a) }//不能省略参数声明
    val result2: (Int) -> Unit = { println(it) }//可以省略参数声明
    result2(30)      //输出结果是30

}