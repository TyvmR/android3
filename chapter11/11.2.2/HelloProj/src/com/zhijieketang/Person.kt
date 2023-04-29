/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/com/zhijieketang/Person.kt
package com.zhijieketang

import java.util.*

open class Person(val name: String,
                  val age: Int,
                  val birthDate: Date) {    //主构造函数
    //次构造函数
    constructor(name: String, age: Int) : this(name, age, Date())

    override fun toString(): String {
        return ("Person [name=$name, age=$age, birthDate=$birthDate]")
    }

}
