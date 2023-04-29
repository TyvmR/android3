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
    //复制User对象
    val user2 = user1.copy(name = "Tom")
    val user3 = user1.copy()

    println(user1 == user2)   //false
    println(user1 == user3)   //true
    println(user1.toString()) //User(name=Tony, password=123)
    println(user2.toString()) //User(name=Tom, password=123)
    println(user3.toString()) //User(name=Tony, password=123)

    println(user1.hashCode())  //81040716
    println(user2.hashCode())  //2661184
    println(user3.hashCode())  //2661184
}
