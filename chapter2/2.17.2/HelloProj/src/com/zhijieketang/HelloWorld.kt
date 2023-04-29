/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val map1 = mutableMapOf<Int, String>()
    val map2 = mutableMapOf(1 to 102, 2 to 360)
    val map3 = hashMapOf<Long, String>()
    val map4 = hashMapOf("R" to "Read", "C" to "Create")

    map1.put(102, "张三")
    map1[105] = "李四"
    map1[109] = "王五"
    map1[110] = "董六"
    //"李四"值重复
    map1[111] = "李四"
    //109键已经存在，替换原来值"王五"
    map1[109] = "刘备"

    // 打印集合元素个数
    println("集合size = " + map1.size)//5
    // 打印集合
    println(map1)//{102=张三, 105=李四, 109=刘备, 110=董六, 111=李四}

    // 删除键值对
    map1.remove(109)
    // 判断键集合中是否包含109
    println("键集合中是否包含109：${map1.containsKey(109)}")//false
    // 判断值集合中是否包含 "李四"
    println("值集合中是否包含\"李四\"：${map1.containsValue("李四")}")//true

    // 判断集合是否为空
    println("集合是空的：" + map2.isEmpty())//false

    // 清空集合
    map1.clear()
    // 打印集合
    println(map1)//{}
}
