/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang


import java.lang.Math.random
import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import kotlin.concurrent.thread

// 编写执行线程代码
fun run() {
    for (i in 0..9) {
        // 打印次数和线程的名字
        println("第${i}次执行 - ${currentThread().name}")

        // 随机生成休眠时间
        val sleepTime = (1000 * random()).toLong()
        // 线程休眠
        sleep(sleepTime)
    }
    // 线程执行结束
    println("执行完成! " + Thread.currentThread().name)
}

fun main() {
    // 创建线程1
    thread {
        run()
    }

    // 创建线程2
    thread(name = "MyThread") {
        run()
    }
}