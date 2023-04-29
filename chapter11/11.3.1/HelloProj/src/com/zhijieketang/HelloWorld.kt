/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

open class ParentClass {
    // x成员属性
    open var x = 10
}

class SubClass : ParentClass() {
    // 屏蔽父类x成员属性
    override var x = 20

    fun print() {
        // 访问子类x成员属性
        println("x = $x")
        // 访问父类x成员属性
        println("super.x = " + super.x)
    }
}

fun main() {
    //实例化子类SubClass
    val pObj = SubClass()
    //调用子类print函数
    pObj.print()
}