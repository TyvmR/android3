/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val list = listOf(1, 3, 34, 54, 75)   //创建list集合
    val map = mapOf(102 to "张三", 105 to "李四", 109 to "王五") //创建Map集合

    println(list.any { it > 10 })   //true
    println(list.all { it > 0 })    //true
    println(list.count { it > 10 }) //3

    println(list.max()) //75
    println(map.maxBy { it.key })   //109=王五

    println(list.min()) //1
    println(map.minBy { it.key })   //102=张三

    println(list.sum()) //167
    println(songs.sumBy { it.durationInSeconds })   //2566

    println(list.average()) //33.4

    println(list.none { it < -1 })   //true

}