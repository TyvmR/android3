/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.lang.Thread.currentThread

fun main() {
    //获取主线程
    val mainThread = currentThread()
    println("主线程名：" + mainThread.name)
}
