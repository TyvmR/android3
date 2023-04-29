/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {
    val a = 0
    val result = divide(5, a)
    println("divide(5, $a) = $result")
}

fun divide(number: Int, divisor: Int): Int {

    try {
        return number / divisor
    } catch (throwable: Throwable) {
        println("message() : " + throwable.message)
        println("toString() : " + throwable.toString())
        println("printStackTrace()输出信息如下：")
        throwable.printStackTrace()
    }

    return 0
}
