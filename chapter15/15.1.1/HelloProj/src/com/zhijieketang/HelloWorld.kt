/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    // 静态初始化
    val intArray1 = arrayOf(21, 32, 43, 45)
    val strArray1 = arrayOf("张三", "李四", "王五", "董六")

    // 动态初始化
    val strArray2 = arrayOfNulls<String>(4)

    // 初始化数组中元素
    strArray2[0] = "张三"
    strArray2[1] = "李四"
    strArray2[2] = "王五"
    strArray2[3] = "董六"
    val intArray2 = Array<Int>(10) { i -> i * i }//可以使用{ it * it }替代
    val intArray3 = Array<Int?>(10) { it * it * it } //可以使用{ i -> i * i * i }替代

    println("----打印intArray2数组----")
    //遍历集合
    for (item in intArray2) {
        println(item)
    }
    
    println("----打印strArray1数组----")
    for (idx in strArray1.indices) {
        println(strArray1[idx])
    }
}
