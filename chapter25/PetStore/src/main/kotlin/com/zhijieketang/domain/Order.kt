/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：PetStore/src/main/kotlin/com/zhijieketang/domain/Order.kt
package com.zhijieketang.domain

import java.math.BigDecimal
import java.util.*

data class Order(
        var orderid: Long = 0,          // 订单Id
        var userid: String? = null,             // 下订单的用户Id
        var orderdate: Date? = null,            // 下订单时间
        var status: Int = 0,            // 订单付款状态 0待付款 1已付款
        var amount: BigDecimal = BigDecimal(0)       // 订单应付金额
)
