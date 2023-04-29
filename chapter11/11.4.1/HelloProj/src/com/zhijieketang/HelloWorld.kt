/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

fun main() {

    val student1 = Student("Tom", 18, "清华大学")
    val student2 = Student("Ben", 28, "北京大学")
    val student3 = Student("Tony", 38, "香港大学")

    val worker1 = Worker("Tom", 18, "钢厂")
    val worker2 = Worker("Ben", 20, "电厂")

    val people = arrayOf(student1, student2, student3, worker1, worker2)

    var studentCount = 0
    var workerCount = 0

    for (item in people) {
        if (item is Worker) {
            workerCount++
        } else if (item is Student) {
            studentCount++
        }
    }
    println("工人人数：$workerCount，学生人数：$studentCount")
    println(worker2 !is Worker)
    println(0 is Int)
}