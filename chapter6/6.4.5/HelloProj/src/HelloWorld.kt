/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val string = "AB12CD34EF"

    val regex = Regex("""\d+""")

    val result = regex.split(string)
    println(result) //[AB, CD, EF]

}