/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：ch9.3.1.kt

fun printArea(width: Double, height: Double): Unit {
    val area = width * height
    println("$width x $height 长方形的面积:$area")
}

fun main() {
    printArea(320.0, 480.0)    //没有采用命名参数函数调用
    printArea(width = 320.0, height = 480.0)//采用命名参数函数调用
    printArea(320.0, height = 480.0)//采用命名函参数数调用
    //printArea(width = 320.0,  480.0) //编译错误
    printArea(height = 480.0, width = 320.0)//采用命名参数函数调用
}