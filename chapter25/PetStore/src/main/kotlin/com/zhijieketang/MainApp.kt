/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/ui/MainApp.kt
package com.zhijieketang

import com.zhijieketang.dao.Account
import com.zhijieketang.ui.LoginFrame
import java.util.*

//用户会话，用户登录成功后，保存当前用户信息
object UserSession {
    var loginDate: Date? = null
    var account: Account? = null
}

fun main() {
    LoginFrame().isVisible = true
}