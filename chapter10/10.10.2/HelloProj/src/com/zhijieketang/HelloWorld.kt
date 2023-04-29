/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//外部类
class Outer {

    // 外部类属性
    val x = 10

    // 外部类函数
    fun printOuter() {
        println("调用外部函数...")
    }

    // 测试调用内部类
    fun test() {
        val inner = Inner()
        inner.display()
    }

    // 内部类
    inner class Inner {

        // 内部类属性
        private val x = 5

        // 内部类函数
        fun display() {
            // 访问外部类的属性x
            println("外部类属性 x = " + this@Outer.x)
            // 访问内部类的属性x
            println("内部类属性 x = " + this.x)
            println("内部类属性 x = $x")

            // 调用外部类的成员函数
            this@Outer.printOuter()
            printOuter()
        }
    }
}

fun main() {

    // 通过外部类访问内部类
    val outer = Outer()
    outer.test()

    // 直接访问内部类
    val inner = Outer().Inner()
    inner.display()
}
