/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.util.*

//private fun <T : Number> isEquals(a: T, b: T): Boolean {
//    return (a == b)
//}

private fun <T : Comparable<T>> isEquals(a: T, b: T): Boolean {
    return (a == b)
}

fun main() {
    println(isEquals(1, 5))     //false
    println(isEquals(1.0, 1.0)) //true
    println(isEquals("a", "a")) //true
    val d1 = Date()
    val d2 = Date()
    println(isEquals(d1, d2)) //true
}
