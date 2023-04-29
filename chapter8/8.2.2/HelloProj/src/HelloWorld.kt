/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：ch8.2.2.kt

fun main() {

    val testScore = 75  //设定一个数值用来测试
    val grade = when (testScore / 10) {
        9 -> '优'
        8 -> '良'
        7, 6 -> '中'
        else -> '差'
    }
    println("Grade = $grade")

    val level = "优"    //设定一个数值用来测试
    val desc = when (level) {
        "优" -> "90分以上"
        "良" -> "80分~90分"
        "中" -> "70分~80分"
        "差" -> "低于60分"
        else -> "无法判断"
    }
    println("说明 = $desc")
}