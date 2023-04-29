/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/mysql/DBSchema.kt
package com.zhijieketang.dao.mysql

import org.jetbrains.exposed.sql.*

const val URL = "jdbc:mysql://localhost:3306/petstore?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
const val DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"
const val DB_USER = "root"
const val DB_PASSWORD = "12345"

/* 用户表 */
object Accounts : Table() {
    //声明表中字段
    val userid = varchar("userid", length = 80) /* 用户Id  */
    override val primaryKey = PrimaryKey(userid, name = "PK_User_ID")
    val password = varchar("password", length = 25)         /* 用户密码 */
    val email = varchar("email", length = 80)               /* 用户Email */
    val name = varchar("name", length = 80)                 /* 用户名 */
    val addr = varchar("addr", length = 80)                 /* 地址 */
    val city = varchar("city", length = 80)                 /* 所在城市 */
    val country = varchar("country", length = 20)           /* 国家 */
    val phone = varchar("phone", length = 80)               /* 电话号码 */
}

/* 商品表 */
object Products : Table() {
    val productid = varchar("productid", length = 10)          /* 商品Id */
    override val primaryKey = PrimaryKey(productid, name = "PK_Produc_ID")
    val category = varchar("category", length = 10)              /* 商品类别 */
    val cname = varchar("cname", length = 80)                    /* 商品中文名 */
    val ename = varchar("ename", length = 80)                    /* 商品英文名 */
    val image = varchar("image", length = 20)                    /* 商品图片 */
    val descn = varchar("descn", length = 255)                   /* 商品描述 */
    val listprice = decimal("listprice", 10, 2)     /* 商品市场价 */
    val unitcost = decimal("unitcost", 10, 2)       /* 商品单价 */
}

/* 订单表 */
object Orders : Table() {
    val orderid = long("orderid")                    /* 订单Id */
    override val primaryKey = PrimaryKey(orderid, name = "PK_Order_ID")

    val userid = varchar("userid", length = 80)             /* 下订单的用户Id */
    val orderdate = long("orderdate")                       /* 下订单时间 */
    val status = integer("status")                          /* 商品单价 */
    val amount = decimal("amount", 10, 2)     /* 订单应付金额 */
}

/* 订单明细表 */
object Orderdetails : Table() {
    val orderid = long("orderid")                       /* 订单Id */
    val productid = varchar("productid", length = 10)   /* 商品Id */

    override val primaryKey = PrimaryKey(orderid, productid, name = "PK_Orderdetails_productid")

    val quantity = integer("quantity")                     /* 商品数量 */
    val unitcost = decimal("unitcost", 10, 2)/* 商品单价 */
}