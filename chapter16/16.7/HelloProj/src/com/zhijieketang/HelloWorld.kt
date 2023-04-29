/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val set = setOf(1, -3, 34, -54, 75)

    //升序
    println(set.sorted())//[-54, -3, 1, 34, 75]
    println("Users升序输出：")
    users.sortedBy { it.name }.forEach { println(it) }
    //降序
    println(set.sortedDescending())//[75, 34, 1, -3, -54]
    println("Users降序输出：")
    users.sortedByDescending { it.name }.forEach { println(it) }

    //倒置
    println(set.reversed())//[75, -54, 34, -3, 1]
}
