/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val i = 0
    var a = 10
    var b = 9

    if (a > b || i == 1) {
        println("或运算为 真")
    } else {
        println("或运算为 假")
    }

    if (a < b && i == 1) {
        println("与运算为 真")
    } else {
        println("与运算为 假")
    }

    if (a > b || a++ == --b) {
        println("a = $a")
        println("b = $b")
    }
}