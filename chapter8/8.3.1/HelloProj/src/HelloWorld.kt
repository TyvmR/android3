/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    var i = 0
    while (i * i < 100_000) {//采用下划线分割数值可读性好
        i++
    }

    println("i = $i")     //输出结果是i = 317
    println("i * i = ${i * i}") //输出结果是i * i = 100489
}