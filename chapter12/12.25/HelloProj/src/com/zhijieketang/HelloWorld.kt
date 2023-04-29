/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {

    //声明接口类型，实例是实现类，发生多态
    val abc = ABC()

    // 访问实现类methodB函数
    println(abc.methodB())

    // 访问默认函数methodC
    println(abc.methodC())

    // 访问默认函数methodD
    println(abc.methodD())

}