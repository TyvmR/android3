/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/mysql/OrderDetailDaoImp.kt
package com.zhijieketang.dao.mysql

import com.zhijieketang.dao.OrderDetailDao
import com.zhijieketang.domain.OrderDetail
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class OrderDetailDaoImp : OrderDetailDao {
    override fun findAll(): List<OrderDetail> {
        TODO("not implemented")
    }

    override fun findByPK(orderid: Long, productid: String): OrderDetail? {

        var orderDetailList: List<OrderDetail> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            //按照主键查询
            orderDetailList =
                Orderdetails.select { Orderdetails.orderid.eq(orderid) and Orderdetails.productid.eq(productid) }
                    .map {
                        val orderDetail = OrderDetail()
                        orderDetail.productid = it[Orderdetails.productid]
                        orderDetail.orderid = it[Orderdetails.orderid]
                        orderDetail.quantity = it[Orderdetails.quantity]
                        orderDetail.unitcost = it[Orderdetails.unitcost]
                        //Lambda表达式返回数据
                        orderDetail
                    }
        }
        return if (orderDetailList.isEmpty()) null else orderDetailList.first()
    }

    override fun create(orderDetail: OrderDetail) {
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            Orderdetails.insert {
                it[orderid] = orderDetail.orderid
                it[productid] = orderDetail.productid!!
                it[quantity] = orderDetail.quantity
                it[unitcost] = orderDetail.unitcost
            }
        }
    }

    override fun modify(orderDetail: OrderDetail) {
        TODO("not implemented")
    }

    override fun remove(orderDetail: OrderDetail) {
        TODO("not implemented")
    }

}