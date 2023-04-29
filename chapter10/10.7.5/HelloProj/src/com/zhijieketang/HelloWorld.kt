/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

private var x: Int = 0

private fun printX() {
    println("Value Of x is$x")
}

fun main() {
    val p = PrivateClass()
    p.printX() //PrivateClass中printX()函数不可见
    p.x //PrivateClass中x属性不可见

    println(x)
    printX()
}