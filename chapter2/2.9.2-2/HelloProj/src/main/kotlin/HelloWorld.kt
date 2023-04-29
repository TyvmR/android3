/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

class Rectangle constructor(var width: Int, var height: Int) {
    // 矩形面积
    var area: Int = width * height

    constructor(width: Int) : this(width, width)

}


fun main() {
    val rect1 = Rectangle(200, 300)
    println("矩形1：${rect1.width} × ${rect1.height}面积 = ${rect1.area}")
    val rect2 = Rectangle(50)
    println("矩形2：${rect2.width} × ${rect2.height}面积 = ${rect2.area}")

}