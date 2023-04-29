/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：chapter11/11.1-1/HelloProj/src/com/zhijieketang/Person.kt
package com.zhijieketang

import java.util.*

class Person : Any() {
    // 名字
    val name: String? = null

    // 年龄
    val age: Int = 0

    // 出生日期
    val birthDate: Date? = null

    open val info: String
        get() = ("Person [name=$name,age=$age,birthDate=$birthDate]")
}
