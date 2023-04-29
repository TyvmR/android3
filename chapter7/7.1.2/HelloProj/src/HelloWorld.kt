/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {
    //声明一个字符类型变量
    val charNum = 'A'   //'A'字符的Unicode编码是65
    // 声明一个整数类型变量
    var intResult = charNum.toInt() + 1
    println(intResult)  //输出66

    intResult = intResult - 1
    println(intResult)  //输出65

    intResult = intResult * 2
    println(intResult)  //输出130

    intResult = intResult / 2
    println(intResult)  //输出65

    intResult = intResult + 8
    intResult = intResult % 7
    println(intResult)  //输出3

    println("-------")

    // 声明一个浮点类型变量
    var doubleResult = 10.0
    println(doubleResult)  //输出10.0

    doubleResult = doubleResult - 1
    println(doubleResult)  //输出9.0

    doubleResult = doubleResult * 2
    println(doubleResult)  //输出18.0

    doubleResult = doubleResult / 2
    println(doubleResult)  //输出9.0

    doubleResult = doubleResult + 8
    doubleResult = doubleResult % 7
    println(doubleResult)  //输出3.0

}