/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/User.kt

package com.zhijieketang

data class User(val name: String, var password: String)

//测试使用
val users = listOf(
    User("Tony", "12%^3"),
    User("Tom", "23##4"),
    User("Ben", "1332%#4"),
    User("Alex", "ac133")
)