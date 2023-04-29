/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//map函数示例

fun main() {
    users.filter { it.name.startsWith("t", ignoreCase = true) }
        .map { it.name }
        .forEach { println(it) }
}
