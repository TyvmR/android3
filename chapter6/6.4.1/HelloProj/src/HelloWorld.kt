/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {
    val pattern = """\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}"""
    val string = "eoreint@sina.com"
    //val regex = Regex(pattern)
    val regex = pattern.toRegex()

    println(regex.matches(string))
}