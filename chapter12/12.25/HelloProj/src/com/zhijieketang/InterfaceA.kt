/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/InterfaceA.kt
package com.zhijieketang

interface InterfaceA {

    fun methodA()
    fun methodB(): String

    fun methodC(): Int {
        return 0
    }

    fun methodD(): String {
        return "这是默认函数..."
    }
}
