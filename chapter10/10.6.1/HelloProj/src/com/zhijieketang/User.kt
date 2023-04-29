/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/User.kt
package com.zhijieketang

//class User(val name: String, var password: String)
//class User constructor(val name: String, var password: String)
//class User private constructor(val name: String, var password: String)

//默认构造函数
class User {
    // 用户名
    var username: String?
    // 用户密码
    var password: String?

    init {
        username = null
        password = null
    }
}
