/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
**/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import kotlin.concurrent.thread

//共享变量
var value = 0

fun main() {

    println("主线程main函数开始...")
    // 创建线程t1
    val t1 = thread {
        println("子线程开始...")
        for (i in 0..1) {
            println("子线程执行...")
            value++
        }
        println("子线程结束...")
    }
    // 主线程被阻塞，等待t1线程结束
    t1.join()
    println("value = $value")
    println("主线程main函数结束...")
}