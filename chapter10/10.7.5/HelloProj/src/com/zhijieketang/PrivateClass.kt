/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/PrivateClass.kt
package com.zhijieketang

class PrivateClass {

    private var x: Int = 0

    private fun printX() {
        println("Value Of x is$x")
    }

    fun display() {
        x = 100
        printX()
    }
}