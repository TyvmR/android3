/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/OrderDetailDao.kt
package com.zhijieketang.dao

import com.zhijieketang.domain.OrderDetail

//订单明细管理DAO
interface OrderDetailDao {

    // 查询所有的订单明细信息
    fun findAll(): List<OrderDetail>

    // 根据主键查询订单明细信息
    fun findByPK(orderid: Long, productid: String): OrderDetail?

    // 创建订单明细信息
    fun create(orderDetail: OrderDetail)

    // 修改订单明细信息
    fun modify(orderDetail: OrderDetail)

    // 删除订单明细信息
    fun remove(orderDetail: OrderDetail)
}