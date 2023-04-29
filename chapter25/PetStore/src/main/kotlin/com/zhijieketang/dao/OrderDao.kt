/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/OrderDao.kt
package com.zhijieketang.dao

import com.zhijieketang.domain.Order

//订单管理DAO
interface OrderDao {
    // 查询所有的订单信息
    fun findAll(): List<Order>

    // 根据主键查询订单信息
    fun findById(orderid: Long): Order?

    // 创建订单信息
    fun create(order: Order)

    // 修改订单信息
    fun modify(order: Order)

    // 删除订单信息
    fun remove(order: Order)

}