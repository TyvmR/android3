/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/com/zhijieketang/Student.kt
package com.zhijieketang

import java.util.*

class Student : Person {

    // 所在学校
    private var school: String? = null

    constructor(
        name: String,
        age: Int = 18,
        birthDate: Date = Date(),
        school: String
    ) : super(name, age, birthDate) {
        this.school = school
    }

    val info: String
        get() = ("Student [name=$name,age=$age,birthDate=$birthDate,school=$school]")
}


