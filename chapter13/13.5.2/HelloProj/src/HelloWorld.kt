/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun square(num: Int): Int = num * num

fun main() {
    val n1: Int? = 10 //null
    //自己进行非空判断
    if (n1 != null) {
        println(square(n1))
    }
    //使用let函数
    n1?.let { n -> println(square(n)) }
    n1?.let { println(square(it)) }

}