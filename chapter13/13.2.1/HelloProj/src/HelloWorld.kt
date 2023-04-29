/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//定义计算长方形面积函数
// 函数类型(Double, Double) -> Double
fun rectangleArea(width: Double, height: Double): Double {
    return width * height
}

//定义计算三角形面积函数
//函数类型(Double, Double) -> Double
fun triangleArea(bottom: Double, height: Double) = 0.5 * bottom * height

fun sayHello() { //函数类型()->Unit
    print("Hello, World")
}

fun main() {

    val getArea: (Double, Double) -> Double = ::triangleArea
    //调用函数
    val area = getArea(50.0, 40.0)
    print(area)//1000.0
}
