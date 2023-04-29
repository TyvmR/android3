/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

//声明除法运算函数，其中n1为分子，n2为分母
fun divide(n1: Int, n2: Int): Double? {

    if (n2 == 0) {//判断分母是否为0
        return null
    }
    return n1.toDouble() / n2
}

fun main() {

    val divNumber1 = divide(100, 10)
    val result1 = divNumber1!!.plus(100)//divNumber1+100，结果110.0
    println(result1)

    val divNumber2 = divide(100, 0)
    val result2 = divNumber2!!.plus(100)//divNumber2+100，结果抛出异常
    println(result2)
}