/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val a = 0B00110010    //十进制50
    val b = 0B01011110    //十进制94

    println("a位或b = " + (a or b))    // 0B01111110，十进制值126
    println("a位与b = " + (a and b))    // 0B00010010，十进制值18
    println("a位异或b = " + (a xor b))    // 0B01101100，十进制值108
    println("b按位取反 = " + b.inv())        // 十进制值-95

    println("a有符号右位移2位 = " + (a shr 2))    // 0B00001100，十进制值12
    println("a有符号右位移1位 = " + a.shr(1))    // 0B00011001，十进制值25
    println("a无符号右位移2位 = " + a.ushr(2))    // 0B00001100，十进制值12
    println("a左位移2位 = " + (a shl 2))    // 0B11001000，十进制值200
    println("a左位移1位 = " + (a shl 1))    // 0B01100100，十进制值100

    val c = -12
    println("c无符号右位移2位 = " + c.ushr(2))
    println("c有符号右位移2位 = " + (c shr 2))

}

