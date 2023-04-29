/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：ch8.2.1.kt

fun main() {

    val testScore = 75  //设定一个数值用来测试
    when (testScore / 10) {
        9 -> {
            println('优')
        }
        8 -> println('良')
        7, 6 -> println('中')
        else -> println('差')
    }

    val level = "优"    //设定一个数值用来测试
    var desc = ""    //接收返回值
    when (level) {
        "优" -> desc = "90分以上"
        "良" -> desc = "80分~90分"
        "中" -> desc = "70分~80分"
        "差" -> desc = "低于60分"
    }
    println("说明 = $desc")

    when {//省略表达式
        testScore >= 90 -> println('优') //分支条件表达式单纯的布尔值
        else -> println('良')
    }

}