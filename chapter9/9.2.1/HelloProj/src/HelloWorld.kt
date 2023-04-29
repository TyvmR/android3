/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun printArea1(width: Double, height: Double): Unit { //可以省略Unit
    val area = width * height
    println("$width x $height 长方形的面积:$area")
    return //可以省略return
}

fun printArea2(width: Double, height: Double) { //省略Unit
    val area = width * height
    println("$width x $height 长方形的面积:$area")
    //省略return
}

fun main() {
    printArea1(320.0, 480.0)
    printArea2(320.0, 480.0)
}