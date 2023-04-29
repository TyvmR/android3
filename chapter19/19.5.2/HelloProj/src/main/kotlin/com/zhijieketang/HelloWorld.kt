/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

suspend fun run(name: String) {
    //启动一个协程
    for (i in 0..9) {
        // 打印协程执行次数
        println("子协程${name}执行第${i}次")
        // 随机生成挂起时间
        val sleepTime = (1000 * Math.random()).toLong()
        // 协程挂起
        delay(sleepTime)
    }
    println("子协程${name}执行结束。")
}

fun main() = runBlocking<Unit> {
    //启动一个协程1
    withTimeout(2000L) {
        run("job1")
    }
    println("主协程结束。")
}