/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

data class Rectangle(var width: Int, val height: Int) {

}

fun main() {
    val rect = Rectangle(200, 300)
    println("矩形面积：${rect.width * rect.height}")
}