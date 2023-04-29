/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//内联函数
inline fun calculatePrint(funN: (Int, Int) -> Int) {
    println("${funN(10, 5)}")
}

fun main() {
    calculatePrint { a, b -> a + b }
    calculatePrint { a, b -> a - b }
}
