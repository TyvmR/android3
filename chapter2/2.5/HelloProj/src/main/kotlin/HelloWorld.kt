/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

fun main() {
    // 声明整数变量
    // 输出一个默认整数常量
    println("默认整数常量 =  " + 16)
    val a: Byte = 16
    val b: Short = 16
    val c = 16
    val d = 16L
    println("Byte整数     =  $a")
    println("Short整数    =  $b")
    println("Int整数      =  $c")
    println("Long整数     =  $d")

    // 输出一个默认浮点常量
    println("默认浮点常量	=  " + 360.66)
    val myMoney = 360.66f
    val yourMoney = 360.66
    println("Float浮点数 	=  $myMoney")
    println("Double浮点数	=  $yourMoney")

    val shortNum: Short = c.toShort()// Int类型转换为Short类型
    val longNum: Long = d.toLong()// Int类型转换为Long类型

    myMoney.toInt()             // Double类型转换为Int类型，结果是360
}
