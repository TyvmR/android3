/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun calculate(n1: Int, n2: Int, opr: Char): Int {

    val multiple = 2

    //声明相加函数
    fun add(a: Int, b: Int): Int {
        return (a + b) * multiple
    }

    //声明相减函数
    fun sub(a: Int, b: Int): Int = (a - b) * multiple

    return if (opr == '+') add(n1, n2) else sub(n1, n2)
}

fun main() {
    println(calculate(10, 5, '+')) //输出结果是30
    //add(10, 5) // 编译错误
    //sub(10, 5) // 编译错误
}