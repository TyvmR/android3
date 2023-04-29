/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/com/zhijieketang/Person.kt
package com.zhijieketang

open class Person(val name: String, val age: Int) {

    override fun toString(): String {
        return ("Person [name=$name,age=$age]")
    }
}
