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

fun getArea(type: String): (Double, Double) -> Double {

    var returnFunction: (Double, Double) -> Double

    when (type) {
        "rect" ->   //rect 表示长方形
            returnFunction = ::rectangleArea
        else ->  //tria 表示三角形
            returnFunction = ::triangleArea
    }

    return returnFunction
}

fun main() {

    //获得计算三角形面积函数
    var area: (Double, Double) -> Double = getArea("tria")
    println("底10 高13，计算三角形面积：${area(10.0, 15.0)}")

    //获得计算长方形面积函数
    area = getArea("rect")
    println("宽10 高15，计算长方形面积：${area(10.0, 15.0)}")
}