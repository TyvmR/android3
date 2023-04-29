/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/com/zhijieketang/Worker.kt
package com.zhijieketang

class Worker(name: String, age: Int, private val factory: String) : Person(name, age) {

    override fun toString(): String {
        return ("Worker [factory=$factory,name=$name,age=$age]")
    }
}
