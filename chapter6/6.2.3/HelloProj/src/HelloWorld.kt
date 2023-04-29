/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val age = 18
    val s1 = "她的年龄是${age}岁。" //使用表达式形式模板
    println(s1)//她的年龄是18岁。

    val score = 'A'
    val s2 = "她的英语成绩是$score" //使用变量形式模板
    println(s2)//她的英语成绩是A

    val now = java.util.Date()
    val s3 = "今天是：${now.year + 1900}年${now.month + 1}月${now.day}日"
    println(s3)

    val s4 = """今天是：
	${now.year + 1900}年
	${now.month + 1}月
	${now.day}日"""//在原始字符串中使用字符串模板
    println(s4)

}