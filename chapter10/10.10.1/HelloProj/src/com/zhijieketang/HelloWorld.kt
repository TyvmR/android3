/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//外部类
class View {

    // 外部类属性
    val x = 20

    // 嵌套类
    class Button {
        // 嵌套类函数
        fun onClick() {
            println("onClick...")
            //不能访问外部类的成员
            //println(x) //编译错误
        }
    }

    // 测试调用嵌套类
    fun test() {
        val button = Button()
        button.onClick()
    }
}

fun main() {

    val button = View.Button()
    button.onClick()

    // 测试调用嵌套类
    val view = View()
    view.test()
}
