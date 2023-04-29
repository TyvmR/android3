/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/com/zhijieketang/Student.kt
package com.zhijieketang

import java.util.*

class Student(
    name: String,
    age: Int,
    birthDate: Date,
    val school: String
) : Person(name, age, birthDate) { //主构造函数

    constructor(
        name: String, //次构造函数
        age: Int,
        school: String
    ) : this(name, age, Date(), school)// super(name, age, Date())

    constructor(
        name: String, //次构造函数
        school: String
    ) : this(name, 18, school)// super(name, 18, Date())

    val info: String
        get() = ("Student [name=$name,age=$age,birthDate=$birthDate,school=$school]")

}
