/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {
    //创建User对象
    val user1 = User("Tony", "123")
    //解构
    val (name1, pwd1) = user1
    println(name1)  //Tony
    println(pwd1)   //123
    val (name2, _) = user1    //省略解构password
    println(name2)  //Tony
}
