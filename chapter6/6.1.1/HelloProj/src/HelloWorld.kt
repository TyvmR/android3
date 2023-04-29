/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val s1 = ""
    val s2 = "Hello World"
    val s3 = "\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064"
    println(s2 == s3)//输出结果为true

    val s4 = "Hello\nWorld"
    val s5 = """Hello
World"""
    println(s4 == s5)//输出结果为true

    val s6 = """Hello\nWorld"""
    println(s6)
}