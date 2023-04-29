/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun calculate1(n1: Int, n2: Int, opr: Char): Int {

    val multiple = 2

    val resultFun = if (opr == '+')
    //声明相加匿名函数
        fun(a: Int, b: Int): Int {
            return (a + b) * multiple
        }
    else
    //声明相减匿名函数
        fun(a: Int, b: Int): Int = (a - b) * multiple
    return resultFun(n1, n2)
}

fun main() {
    println(calculate1(10, 5, '+')) //输出结果是30
}