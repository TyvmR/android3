/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val score = 95

    // 1. if-else结构
    val result1 = if (score < 60) {
        println("不及格")
    } else {
        println("及格")
    }

    val result2 = if (score < 60) {
        println("不及格")
        "重新考试"
    } else {
        println("及格")
        "通过考试"
    }

    // 2. else-if结构
    val testScore = 76
    val grade: Char = if (testScore >= 90)
        'A'
    else if (testScore >= 80)
        'B'
    else if (testScore >= 70)
        'C'
    else if (testScore >= 60)
        'D'
    else
        'F'

    println("Grade = $grade")
}