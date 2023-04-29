/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val map1 = mapOf(102 to "张三", 105 to "李四", 109 to "王五")
    val map2 = mapOf<Int, String>()
    val map3 = mapOf(1 to 200)

    // 打印集合元素个数
    println("集合size = " + map1.size)//3
    // 打印集合
    println(map1)//{102=张三, 105=李四, 109=王五}

    // 通过键取值
    println("102 - ${map1[102]}")//102 - 张三
    println("105 - ${map1[105]}")//105 - 李四

    // 判断键集合中是否包含109
    println("键集合中是否包含109：${map1.containsKey(109)}")//true
    // 判断值集合中是否包含 "李四"
    println("值集合中是否包含\"李四\"：${map1.containsValue("李四")}")//true

    // 判断集合是否为空
    println("集合是空的：" + map2.isEmpty())//true

    // 1.使用for循环遍历
    println("--1.使用for循环遍历--")
    // 获得键集合
    val keys = map1.keys
    for (key in keys) {
        println("key=${key} - value=${map1[key]}")
    }

    // 2.使用迭代器遍历
    println("--2.使用迭代器遍历--")
    // 获得值集合
    val values = map1.values
    // 遍历值集合
    val it = values.iterator()
    while (it.hasNext()) {
        val item = it.next()
        println("值集合元素: $item")
    }

}
