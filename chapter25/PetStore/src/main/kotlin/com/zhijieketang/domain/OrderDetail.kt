/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：PetStore/src/main/kotlin/com/zhijieketang/domain/OrderDetail.kt
package com.zhijieketang.domain

import java.math.BigDecimal

//订单明细
data class OrderDetail(
        var orderid: Long = 0,          // 订单Id
        var productid: String? = null,  // 商品Id
        var quantity: Int = 0,          // 商品数量
        var unitcost: BigDecimal = BigDecimal(0)   // 单价
)