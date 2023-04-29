/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    // 创建协程
    val job = launch {
        // 一直循环，直到满足条件在取消协程
        while (true) {
            // 协程开始工作
            // TODO
            println("下载中...")
            delay(10000L)
        }
    }

    val command = readLine()// 读取从键盘的字符串
    if (command == "exit") {
        job.cancel()//取消协程
        job.join()//等待协程结束
        //job.cancelAndJoin()//取消协程并等待协程job结束
    }
}

