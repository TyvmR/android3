/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

val <T> ArrayList<T>.first: T?  //获得第一个元素
    get() = if (this.size > 1) this[0] else null

val <T> ArrayList<T>.second: T? //获得第二个元素
    get() = if (this.size > 2) this[1] else null

fun main() {

    val array1 = ArrayList<Int>()//等同于arrayListOf<Int>()
    println(array1.first)   //null
    println(array1.second)  //null

    val array2 = arrayListOf("A", "B", "C", "D")
    println(array2.first)   //A
    println(array2.second)  //B

}