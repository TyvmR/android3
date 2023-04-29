/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：HelloProj/src/main/kotlin/com/zhijieketang/Animal.kt
package com.zhijieketang;

class Animal @JvmOverloads constructor(val age: Int, val sex: Boolean = false)

class DisplayOverloading {
    @JvmOverloads
    fun display(c: Char, num: Int = 1) {
        println("$c $num")
    }
}

@JvmOverloads
fun makeCoffee(type: String = "卡布奇诺"): String {
    return "制作一杯${type}咖啡。"
}