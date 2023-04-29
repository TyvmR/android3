/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val map = mapOf(102 to "张三", 105 to "李四", 109 to "王五")
    val array = intArrayOf(1, 3, 34, 54, 75)
    val charList = listOf("A", null, "B", "C")

    println(array.drop(2))               //[34, 54, 75]

    println(map.filter { it.key > 102 })    //{105=李四, 109=王五}
    println(map.filterNot { it.key > 102 }) //{102=张三}
    println(charList.filterNotNull())//[A, B, C]

    println(array.slice(listOf(0, 2)))       //[1, 34]

    println(array.take(3))       //[1, 3, 34]
    println(array.takeLast(3))   //[34, 54, 75]

    println(array.find { it > 10 })       //34
    println(array.findLast { it < -1 })   //null

    println(array.first())       //1
    println(array.last())        //75
    println(array.first { it > 10 })        //34
    println(array.firstOrNull { it > 100 }) //null
    println(array.last { it > 10 })         //75
    println(array.lastOrNull { it > 100 })  //null

}