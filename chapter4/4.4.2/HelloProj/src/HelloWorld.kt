/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

public fun main() {

    val englishScore = 95
    val chineseScore = 98

    //if控制结构表达式
    val result = if (englishScore < 60) "不及格" else "及格"
    println(result)

    val totalScore = sum(englishScore, chineseScore)
    println(totalScore)

    //try表达式
    val score = try {
        //TODO
    } catch (e: Exception) {
        return
    }
}

fun sum(a: Int, b: Int): Int = a + b    //表达式函数体