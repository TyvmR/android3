/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

fun main() {

    val s1 = "Hello"
    // 使用+运算符连接
    var s2 = s1 + " " // 使用+运算符连接，
    s2 += "World"   // 支持+=赋值运算符
    println(s2)//Hello World

    val age = 18
    val s3 = "她的年龄是" + age + "岁。"
    println(s3)//她的年龄是18岁。

    val s4 = "她的年龄是 ${age}岁。"
    println(s4)//她的年龄是18岁。

}