/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/Figure.kt
package com.zhijieketang

abstract class Figure {
    //绘制几何图形函数
    abstract fun onDraw()   //抽象函数

    abstract val name: String  //抽象属性
    val cname: String = "几何图形" //具体属性

    fun display() {//具体函数
        println(name)
    }
}
