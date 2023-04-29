/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun makeArray(): (Int) -> Int {

    var ary = 0

//    //局部函数捕获变量
//    fun add(element: Int): Int {
//        ary += element
//        return ary
//    }
//
//    return ::add

//Lambda表达式形式捕获变量
//    return { element ->
//        ary += element
//        ary
//    }

//匿名函数形式捕获变量
    return fun(element: Int): Int {
        ary += element
        return ary
    }
}

fun main() {
    val f1 = makeArray()
    println("---f1---")
    println(f1(10))//累加ary变量，输出结果是10
    println(f1(20))//累加ary变量，输出结果是30
    println(f1(30))//累加ary变量，输出结果是60
}