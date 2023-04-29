/*
 * Created by 画画的程序员
 * 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
 * 邮箱：eorient@sina.com
 *
 */

//Kotlin代码文件：HelloProj/src/main/kotlin/com/zhijieketang/Person.kt

package com.zhijieketang;

import java.util.*

class Person {
    // 名字
    @JvmField
    var name = "Tony"

    // 年龄
    var age = 18

    // 出生日期
    lateinit var birthDate: Date
}
