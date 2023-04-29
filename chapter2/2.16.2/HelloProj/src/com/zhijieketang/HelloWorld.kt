/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val list1 = mutableListOf(1, 3, 34, 54, 75)
    val list2 = mutableListOf<String>()
    val list3 = arrayListOf<Long?>()
    val list4 = arrayListOf("B", "D", "F")

    val b = "B"
    // 向list2集合中添加元素
    list2.add("A")
    list2.add(b)
    list2.add("C")
    list2.add(b)
    list2.add("D")
    list2.add("E")

    // 打印集合元素个数
    println("集合size = ${list2.size}")
    // 打印集合
    println(list2)

    // 删除集合中第一个"B"元素
    list2.remove(b)
    // 判断集合中是否包含"B"元素
    println("""是否包含"B"：${list2.contains(b)}""")//false
    // 判断集合是否为空
    println("集合是空的：${list2.isEmpty()}")//false

    // 清空集合
    list2.clear()
    println(list2.isEmpty())//true

    // 向list3集合中添加元素
    list3.add(3)
    list3.add(4)
    list3.add(6)

    // 1.使用for循环遍历
    println("--1.使用for循环遍历--")
    for (item in list2) {
        println("读取集合元素: $item")
    }

    // 2.使用迭代器遍历
    println("--2.使用迭代器遍历--")
    val it = list3.iterator()
    while (it.hasNext()) {
        val item = it.next()
        println("读取集合元素: $item")
    }
}
