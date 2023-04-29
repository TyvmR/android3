/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

fun makeCoffee(type: String = "卡布奇诺"): String {
    return "制作一杯${type}咖啡。"
}


fun main() {

    val coffee1 = makeCoffee("拿铁")
    val coffee2 = makeCoffee()

    println(coffee1)//制作一杯拿铁咖啡。
    println(coffee2)//制作一杯卡布奇诺咖啡。
}