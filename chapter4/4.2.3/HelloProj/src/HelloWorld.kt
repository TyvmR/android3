/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

class Person(val name: String, val age: Int)

public fun main() {

    val p1 = Person("Tony", 18)

    println(p1.name)
    println(p1.age)

    p1 = Person("Tom", 20) //编译错误
}