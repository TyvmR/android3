/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val strArray = arrayOf("张三", "李四", "王五", "董六")//创建字符串数组
    val set = setOf(1, 3, 34, 54, 75)   //创建Set集合
    val map = mapOf(102 to "张三", 105 to "李四", 109 to "王五") //创建Map集合

    println("-----遍历数组-----")
    strArray.forEach {
        println(it)
    }

    println("-----遍历Set集合-----")
    set.forEach {
        println(it)
    }

    println("-----遍历Map集合k,v-----")
    map.forEach { k, v ->
        println("$k - $v")
    }
    println("-----遍历Map集合Entry-----")
    map.forEach {
        println("${it.key} - ${it.value}")
    }
}