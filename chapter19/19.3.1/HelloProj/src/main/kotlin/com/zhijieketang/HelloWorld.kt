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


fun main() {
    GlobalScope.launch {        // 创建一并启动个协程在后台执行
        delay(1000L)   // 非阻塞延迟1秒
        println("World！")      // 协程打印
        println("协程结束。")
    }
    println("Hello，")          // 主线程打印
    Thread.sleep(5000L)   // 主线程被阻塞5秒
    println("主线程结束。")
}
