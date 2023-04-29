/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

fun main() {

    fun main() {

        val p1: Person = Student("Tom", 18, "清华大学")
        val p2: Person = Worker("Tom", 18, "钢厂")

        val p3 = Person("Tom", 28)
        val p4 = Student("Ben", 40, "清华大学")
        val p5 = Worker("Tony", 28, "钢厂")

        // 向上转型
        val p41: Person = p4 //as Person
        val p51 = p5 as Person

        // 向下转型
        val p11 = p1 as Student
        val p21 = p2 as Worker

        val p211 = p2 as? Student //使用as会发生运行时异常
        val p111 = p1 as? Worker  //使用as会发生运行时异常
        val p311 = p3 as? Student //使用as会发生运行时异常
    }
}