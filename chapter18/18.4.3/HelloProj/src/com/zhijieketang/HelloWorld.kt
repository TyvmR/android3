/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.lang.Thread.sleep
import kotlin.concurrent.thread

var command = ""

fun main() {
    // 创建线程t1
    val t1 = thread {

        // 一直循环，直到满足条件在停止线程
        while (command != "exit") {
            // 线程开始工作
            // TODO
            println("下载中...")
            // 线程休眠
            sleep(10000)
        }
        // 线程执行结束
        println("执行完成!")
    }
    command = readLine()!!// 接收从键盘输入的字符串
}