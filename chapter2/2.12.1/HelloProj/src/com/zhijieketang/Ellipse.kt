/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/Ellipse.kt
package com.zhijieketang

//几何图形椭圆形
class Ellipse : Figure() {
    override val name: String
        get() = "椭圆形"

    //绘制几何图形函数
    override fun onDraw() {
        println("绘制椭圆形...")
    }
}
