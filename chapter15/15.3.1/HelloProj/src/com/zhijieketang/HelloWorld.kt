/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val set1 = setOf("ABC")     //[ABC]
    val set2 = setOf<Long?>()   //[]
    val set3 = setOf(1, 3, 34, 54, 75)//[1, 3, 34, 54, 75]

    println(set1.size)       //1
    println(set2.isEmpty())     //true
    println(set3.contains(75))  //true

    // 1.使用for循环遍历
    println("--1.使用for循环遍历--")
    for (item in set3) {
        println("读取集合元素: $item")
    }

    // 2.使用迭代器遍历
    println("--2.使用迭代器遍历--")
    val it = set3.iterator()
    while (it.hasNext()) {
        val item = it.next()
        println("读取集合元素: $item")
    }
}
