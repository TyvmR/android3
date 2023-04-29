/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt

package com.zhijieketang


fun main() {

    // f1变量是父类类型，指向父类实例
    val f1 = Figure()
    f1.onDraw()

    // f2变量是父类类型，指向子类实例，发生多态
    val f2: Figure = Triangle()
    f2.onDraw()

    // f3变量是父类类型，指向子类实例，发生多态
    val f3: Figure = Ellipse()
    f3.onDraw()

    // f4变量是子类类型，指向子类实例
    val f4 = Triangle()
    f4.onDraw()
}