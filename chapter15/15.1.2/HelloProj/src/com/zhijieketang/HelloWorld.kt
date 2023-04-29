/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：chapter15/src/com/HelloWorld.kt

package com.zhijieketang

fun main() {
    // 静态初始化
    val array1 = shortArrayOf(20, 10, 50, 40, 30)
    // 动态初始化
    val array2 = CharArray(3)
    println(array2[0] == '\u0000')
    array2[0] = 'C'
    array2[1] = 'B'
    array2[2] = 'D'
    // 动态初始化
    val array3 = IntArray(10) { it * it }

    //遍历集合
    for (item in array3) {
        println(item)
    }
    println()
    for (idx in array2.indices) {
        println(array2[idx])
    }
}
