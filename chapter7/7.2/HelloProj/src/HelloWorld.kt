/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val value1 = 1
    val value2 = 2
    println(value1 == value2)         //输出结果为false
    println(value1.toDouble() == 1.0) //输出结果为true
    println(value1 != value2)         //输出结果为true
    println(value1 > value2)          //输出结果为false
    println(value1 < value2)          //输出结果为true
    println(value1 <= value2)         //输出结果为true

    val p1 = Person("Tony", 18)
    val p2 = Person("Tony", 18)
    val p3 = Person("Tom", 20)
    val p4 = p3

    println(p1 == p2)         //输出结果为true
    println(p1 == p3)         //输出结果为false
    println(p3 === p4)        //输出结果为true

}