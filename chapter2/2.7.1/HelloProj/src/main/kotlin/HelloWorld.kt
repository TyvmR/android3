/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

fun rectangleArea(width: Double, height: Double): Double {
    val area = width * height
    return area
}

fun main() {
    println("320x480的长方形的面积:${rectangleArea(320.0, 480.0)}")
}