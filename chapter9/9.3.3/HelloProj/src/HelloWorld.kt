/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun sum(vararg numbers: Double, multiple: Int = 1): Double {
    var total = 0.0
    for (number in numbers) {
        total += number
    }
    return total * multiple
}

fun main() {
    println(sum(100.0, 20.0, 30.0))    //输出150.0
    println(sum(30.0, 80.0))        //输出110.0
    println(sum(30.0, 80.0, multiple = 2))   //输出220.0

    val doubleAry = doubleArrayOf(50.0, 60.0, 0.0)
    println(sum(30.0, 80.0, *doubleAry)) //输出220.0
}
