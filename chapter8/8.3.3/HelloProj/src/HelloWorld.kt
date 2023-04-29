/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    for (num in 1..9) { //使用区间运算符
        println("$num x $num = ${num * num}")
    }

    // 声明并初始化Int数组
    val numbers = intArrayOf(43, 32, 53, 54, 75, 7, 10)
    // for语句
    for (item in numbers) {
        println("Count is:$item")
    }
    for (i in numbers.indices) { //获取数组索引
        println("numbers[$i] = ${numbers[i]}")
    }
}