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

//高阶函数，funcName参数是函数类型
fun getAreaByFunc(funcName: (Double, Double) -> Double, a: Double, b: Double): Double {
    return funcName(a, b)
}

fun main() {
    //获得计算三角形面积函数
    var result: Double = getAreaByFunc(::triangleArea, 10.0, 15.0)
    println("底10 高15，计算三角形面积：$result")

    //获得计算长方形面积函数
    result = getAreaByFunc(::rectangleArea, 10.0, 15.0)
    println("宽10 高15，计算长方形面积：$result")
}