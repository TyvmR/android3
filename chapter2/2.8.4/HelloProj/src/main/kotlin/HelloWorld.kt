/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

fun calculate(opr: Char): (Int, Int) -> Int {

    return when (opr) {
        '+' -> { a, b -> a + b }
        '-' -> { a, b -> a - b }
        '*' -> { a, b -> a * b }
        else -> { a, b -> a / b }
    }
}

fun main() {

    val f1 = calculate('+')
    println(f1(10, 5))  //调用f1变量 返回15
    val f2 = calculate('-')
    println(f2(10, 5)) //调用f2变量 返回5
    val f3 = calculate('*')
    println(f3(10, 5))  //调用f3变量 返回50
    val f4 = calculate('/')
    println(f4(10, 5)) //调用f4变量 返回2

}
