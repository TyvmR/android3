/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {
    //全部是数字模式
    val regex = Regex("""\d+""")

    val input1 = "1000"
    val input2 = "￥1000"

    println(regex.matches(input1))//true
    println(regex.matches(input2))//false

    println(regex.containsMatchIn(input1))//true
    println(regex.containsMatchIn(input2))//true
}