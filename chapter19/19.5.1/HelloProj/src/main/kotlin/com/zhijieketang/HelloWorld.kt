/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//共享变量
var value = 0

fun main() = runBlocking<Unit> {

    println("主协程开始...")
    // 创建协程job1
    val job1 = launch {
        println("子协程开始...")
        for (i in 0..1) {
            println("子协程执行...")
            value++
        }
        println("子协程结束...")
    }
    // 主协程被挂起，等待job1协程结束
    ///job1.join()
    println("value = $value")
    println("主协程结束...")
}