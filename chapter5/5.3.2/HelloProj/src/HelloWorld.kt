/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    // 声明整数常量
    val b: Byte = 16
    val s: Short = 16
    val i = 16
    val l = 16L

    // 声明浮点变量
    val f = 10.8f
    val d = 10.8

    val result1 = b + b         //结果是Int类型
    val result2 = b + s         //结果是Int类型
    val result3 = b + s - i     //结果是Int类型
    val result4 = b + s - i + l   //结果是Long类型

    val result5 = b * s + i + f / l           //结果是Float类型
    val result6 = b * s + i + f / l + d     //结果是Double类型

}
