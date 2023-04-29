/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/domain/Account.kt
package com.zhijieketang.dao

data class Account(
        var userid: String? = null,     // 用户Id
        var username: String? = null,   // 用户名
        var password: String? = null,   // 用户密码
        var phone: String? = null,      // 电话号码
        var country: String? = null,    //国家
        var city: String? = null,       // 所在城市
        var addr: String? = null,       // 地址
        var email: String? = null      // 用户Email
)