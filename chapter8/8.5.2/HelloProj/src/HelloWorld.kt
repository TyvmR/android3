/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    var testscore = 80 //设置一个分数用于测试
    var grade = when (testscore) {
        in 90..100 -> "优"
        in 80 until 90 -> "良"
        in 60 until 80 -> "中"
        in 0 until 60 -> "差"
        else -> "无"
    }
    println("Grade = $grade")

    if (testscore !in 60..100) { //使用!in关键字
        println("不及格")
    }
    val strArray = arrayOf("刘备", "关羽", "张飞")
    val name = "赵云"
    if (name !in strArray) {
        println(name + "不在队伍中")
    }
}