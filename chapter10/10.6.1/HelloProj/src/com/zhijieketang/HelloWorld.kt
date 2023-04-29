/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//定义中缀函数interestBy
infix fun Double.interestBy(interestRate: Double): Double {
    return this * interestRate
}

// 部门类
class Department {
    var no: Int = 10      // 部门编号属性

    //定义中缀函数rp
    infix fun rp(times: Int) {
        repeat(times) {
            println(no)
        }
    }
}

fun main() {

    //创建Rectangle对象
    val rect1 = Rectangle(100, 90)
    val rect2 = Rectangle(10, 9, 900)
    val rect3 = Rectangle(20000)
    println("绘制${rect3.width}X${rect3.height}矩形面积是${rect3.area}")

    //创建Animal对象
    val animal1 = Animal()
    val animal2 = Animal(10)
    val animal3 = Animal(sex = true)
    val animal4 = Animal(10, true)

    //创建User对象
    val user = User()

}