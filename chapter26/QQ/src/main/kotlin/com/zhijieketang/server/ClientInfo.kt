/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：QQ/src/main/kotlin/com/zhijieketang/server/ClientInfo.kt
package com.zhijieketang.server

import java.net.InetAddress

data class ClientInfo(
        val port: Int,// 客户端端口号
        val address: InetAddress,// 客户端IP地址
        val userId: String)// 用户Id