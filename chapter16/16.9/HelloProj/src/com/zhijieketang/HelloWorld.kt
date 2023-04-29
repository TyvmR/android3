/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//计算水仙花
fun main() {

    val numbers = IntArray(1000) { it }//初始化0~999共计1000个元素Int数组

    numbers.filter { it > 99 }  //过滤第一次
        .filter {           //过滤第二次
            val r = it / 100  //百位数
            val s = (it - r * 100) / 10//十位数
            val t = it - r * 100 - s * 10//个位数

            it == r * r * r + s * s * s + t * t * t
        }.forEach { println(it) }//遍历打印输出
}

