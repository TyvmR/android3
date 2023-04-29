/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val sourceStr = "There is a string accessing example."
    // 截取example.子字符串
    val subStr1 = sourceStr.substring(28)
    // 截取string子字符串
    val subStr2 = sourceStr.substring(11, 17)
    // 参数是区间
    val subStr3 = sourceStr.substring(11..17)

    println(subStr1)
    println(subStr2)
    println(subStr3)

}