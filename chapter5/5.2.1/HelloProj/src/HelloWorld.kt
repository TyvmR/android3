/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

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

    //数字常量添加下划线，增强可读性
    val e = 160_000_000L  //表示160000000数字
    println("数字常量添加下划线   =  $e")

    // 进制表示方式
    val decimalInt = 28         //十进制表示
    val binaryInt1 = 0b11100    //二进制表示
    val binaryInt2 = 0B11100    //二进制表示
    val hexadecimalInt1 = 0x1C    //十六进制表示
    val hexadecimalInt2 = 0X1C    //十六进制表示
}
