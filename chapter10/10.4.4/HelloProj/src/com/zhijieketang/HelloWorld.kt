/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/ch10.4.4.kt
package com.zhijieketang

import kotlin.reflect.KProperty

class User {
    var name: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any, property: KProperty<*>): String = property.name

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println(value)
    }
}

fun main() {

    val user = User()
    user.name = "Tom"
    println(user.name)

}