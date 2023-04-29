/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/ProtectedClass.kt
package com.zhijieketang

open class ProtectedClass {

    protected var x: Int = 0

    init {
        x = 100
    }

    protected fun printX() {
        println("Value Of x is $x")
    }
}
