/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang
//声明View类
class View {
    fun handler(listener: OnClickListener) {
        listener.onClick()
    }
}

//声明OnClickListener接口
interface OnClickListener {
    fun onClick()
}

//声明Person类
open class Person(val name: String, val age: Int)

fun main() {
    var i = 10
    val v = View()
    // 对象表达式作为函数参数
    v.handler(object : OnClickListener {

        override fun onClick() {
            println("对象表达式作为函数参数...")
            println(++i)
        }

    })

    //对象表达式赋值
    val person = object : Person("Tony", 18), OnClickListener {
        //实现接口onClick函数
        override fun onClick() {
            println("实现接口onClick函数...")
        }

        //重写toString函数
        override fun toString(): String {
            println(++i)
            return ("Person[name=$name, age=$age]")
        }
    }
    println(person)

    //无具体父类对象表达式
    var rectangle = object {

        // 矩形宽度
        var width: Int = 200

        // 矩形高度
        var height: Int = 300

        //重写toString函数
        override fun toString(): String {
            println(++i)
            return ("[width=$width, height=$height]")
        }
    }

    println(rectangle)
}
