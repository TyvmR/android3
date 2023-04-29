/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/mysql/OrderDaoImp.kt
package com.zhijieketang.dao.mysql

import com.zhijieketang.dao.OrderDao
import com.zhijieketang.domain.Order
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class OrderDaoImp : OrderDao {

    override fun findAll(): List<Order> {

        var orderList: List<Order> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            orderList = Orders.selectAll().map {
                val order = Order()
                order.orderid = it[Orders.orderid]
                order.userid = it[Orders.userid]
                order.orderdate = Date(it[Orders.orderdate]) 
                order.status = it[Orders.status]
                order.amount = it[Orders.amount]
                //Lambda表达式返回数据
                order
            }
        }
        return orderList
    }

    override fun findById(orderid: Long): Order? {
        TODO("not implemented")
    }

    override fun create(order: Order) {
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            Orders.insert {
                it[Orders.orderid] = order.orderid
                it[Orders.userid] = order.userid!!
                val now = Date() // 获得当前时间
                it[Orders.orderdate] = now.time // 用long表示的时间戳
                it[Orders.status] = order.status
                it[Orders.amount] = order.amount
            }
        }
    }

    override fun modify(order: Order) {
        TODO("not implemented")
    }

    override fun remove(order: Order) {
        TODO("not implemented")
    }
}