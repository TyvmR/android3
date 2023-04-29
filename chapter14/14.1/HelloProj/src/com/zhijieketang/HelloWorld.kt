/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

private fun isEqualsInt(a: Int, b: Int): Boolean {
    return (a == b)
}

private fun isEqualsDouble(a: Double, b: Double): Boolean {
    return (a == b)
}

private fun isEqualsString(a: String, b: String): Boolean {
    return (a == b)
}

private fun <T> isEquals(a: T, b: T): Boolean {
    return (a == b)
}

fun main() {

    println(isEqualsInt(1, 5))
    println(isEqualsDouble(1.0, 5.0))
    println(isEqualsString("1", "1"))

    println(isEquals(1, 5))
    println(isEquals(1.0, 5.0))

}
