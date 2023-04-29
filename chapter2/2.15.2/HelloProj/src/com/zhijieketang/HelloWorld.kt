/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val set1 = mutableSetOf(1, 3, 34, 54, 75)
    val set2 = mutableSetOf<String>()
    val set3 = hashSetOf<Long?>()
    val set4 = hashSetOf("B", "D", "F")

    val b = "B"
    // 向set2集合中添加元素
    set2.add("A")
    set2.add(b)
    set2.add("C")
    set2.add(b)
    set2.add("D")
    set2.add("E")

    // 打印集合元素个数
    println("集合size = ${set2.size}")
    // 打印集合
    println(set2)

    // 删除集合中第一个"B"元素
    set2.remove(b)
    // 判断集合中是否包含"B"元素
    println("""是否包含"B"：${set2.contains(b)}""")//false
    // 判断集合是否为空
    println("set集合是空的：${set2.isEmpty()}")//false

    // 清空集合
    set2.clear()
    println(set2.isEmpty())//true

    // 向set3集合中添加元素
    set3.add(3)
    set3.add(4)
    set3.add(6)

    // 1.使用for循环遍历
    println("--1.使用for循环遍历--")
    for (item in set2) {
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
