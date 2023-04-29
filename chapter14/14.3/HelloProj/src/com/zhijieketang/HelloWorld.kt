/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    val genericQueue = Queue<String>()
    genericQueue.queue("A")
    genericQueue.queue("C")
    genericQueue.queue("B")
    genericQueue.queue("D")
    //genericQueue.queue(1);//编译错误

    println(genericQueue)
    genericQueue.dequeue()

    println(genericQueue)
}