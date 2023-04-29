/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

private fun <T : Any> isEquals(a: T, b: T): Boolean {
    return (a == b)
}

//private fun <T> isEquals(a: T, b: T): Boolean {
//    return (a == b)
//}

fun main() {
    //println(isEquals(null, 5))  //编译错误
    //println(isEquals(1.0, null)) //编译错误
}
