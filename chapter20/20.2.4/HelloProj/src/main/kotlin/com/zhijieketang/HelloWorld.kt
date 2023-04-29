/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//Kotlin代码文件：HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

fun main() {

    val n1 = 10
    val n2 = 5

    // 实现加法计算Calculable对象
    val f1 = Calculable { a, b -> a + b }
    // 实现减法计算Calculable对象
    val f2 = Calculable { a, b -> a - b }

    // 调用calculateInt函数进行加法计算
    println("$n1 + $n2 = ${f1.calculateInt(n1, n2)}")
    // 调用calculateInt函数进行减法计算
    println("$n1 - $n2 = ${f2.calculateInt(n1, n2)}")

}
