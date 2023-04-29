/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/Triangle.kt
package com.zhijieketang

//几何图形三角形
class Triangle(override val name: String) : Figure() {
    // 绘制几何图形函数
    override fun onDraw() {
        println("绘制三角形...")
    }
}
