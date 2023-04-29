/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

fun main() {
    val job = GlobalScope.launch {
        for (i in 0..9) {
            // 打印协程执行次数
            println("协程执行第${i}次")
            delay(1000)
        }
        println("-协程执行结束。")
    }

    sleep(15000L)
    println("+主线程结束。")
    println(job.isCompleted) //true
}
