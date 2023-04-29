/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    // 声明整数常量
    val byteNum: Byte = 16
    //val shortNum: Short = byteNum //编译错误
    val shortNum: Short = byteNum.toShort()// Byte类型转换为Short类型
    var intNum = 16

    val longNum: Long = intNum.toLong()// Int类型转换为Long类型
    intNum = longNum.toInt()    // Long类型转换为Int类型

    val doubleNum = 10.8
    println("doubleNum.toInt : " + doubleNum.toInt())// Double类型转换为Int类型，结果是10
    // 声明Char常量
    val charNum = 'A'
    println("charNum.toInt : " + charNum.toInt())// Char类型转换为Int类型，结果是65

    //精度丢失问题
    val llongNum = 6666666666L
    println("llongNum : $llongNum")
    println("llongNum.toInt : " + llongNum.toInt())//结果是-1923267926，精度丢失

}
