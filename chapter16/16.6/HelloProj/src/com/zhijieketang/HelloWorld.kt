/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val set = setOf(1, 3, 34, 54, 75)
    val charList = listOf("A", null, "b", "C")

    println(charList.mapNotNull { it }      //[A, b, C]
        .map { it.toLowerCase() })    //[a, b, c]
    println(set.mapIndexed { index, s -> index + s })//[1, 4, 36, 57, 79]

    val datas = listOf(listOf(10, 20), listOf(20, 40))
    val flatMapList = datas.flatMap { e ->
        e.map { it * 10 }
    }
    println(flatMapList)//[100, 200, 200, 400]
}
