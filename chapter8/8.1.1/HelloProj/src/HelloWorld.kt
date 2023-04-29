/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {
    // 1. if结构
    val score = 95
    if (score >= 85) {
        println("您真优秀！")
    }
    if (score < 60) {
        println("您需要加倍努力！")
    }
    if (score >= 60 && score < 85) {
        println("您的成绩还可以，仍需继续努力！")
    }

    // 2. if-else结构
    if (score < 60) {
        println("不及格")
    } else {
        println("及格")
    }

    // 3. else-if结构
    val testScore = 76
    val grade: Char
    if (testScore >= 90) {
        grade = 'A'
    } else if (testScore >= 80) {
        grade = 'B'
    } else if (testScore >= 70) {
        grade = 'C'
    } else if (testScore >= 60) {
        grade = 'D'
    } else {
        grade = 'F'
    }
    println("Grade = $grade")
}