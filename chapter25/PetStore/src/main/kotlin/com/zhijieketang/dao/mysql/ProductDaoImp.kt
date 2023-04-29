/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/mysql/ProductDaoImp.kt
package com.zhijieketang.dao.mysql

import com.zhijieketang.dao.ProductDao
import com.zhijieketang.domain.Product
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class ProductDaoImp : ProductDao {

    override fun findAll(): List<Product> {
        var productList: List<Product> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            productList = Products.selectAll().map {
                val product = Product()
                product.productid = it[Products.productid]
                product.category = it[Products.category]
                product.cname = it[Products.cname]
                product.ename = it[Products.ename]
                product.image = it[Products.image]
                product.descn = it[Products.descn]
                product.listprice = it[Products.listprice]
                product.unitcost = it[Products.unitcost]
                //Lambda表达式返回数据
                product
            }
        }

        return productList
    }

    override fun findById(productid: String): Product? {
        var productList: List<Product> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            //按照主键查询
            productList = Products.select { Products.productid.eq(productid) }.map {
                val product = Product()
                product.productid = it[Products.productid]
                product.category = it[Products.category]
                product.cname = it[Products.cname]
                product.ename = it[Products.ename]
                product.image = it[Products.image]
                product.descn = it[Products.descn]
                product.listprice = it[Products.listprice]
                product.unitcost = it[Products.unitcost]
                //Lambda表达式返回数据
                product
            }
        }
        return if (productList.isEmpty()) null else productList.first()
    }

    override fun findByCategory(category: String): List<Product> {
        var productList: List<Product> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            //按照主键查询
            productList = Products.select { Products.category.eq(category) }.map {
                val product = Product()
                product.productid = it[Products.productid]
                product.category = it[Products.category]
                product.cname = it[Products.cname]
                product.ename = it[Products.ename]
                product.image = it[Products.image]
                product.descn = it[Products.descn]
                product.listprice = it[Products.listprice]
                product.unitcost = it[Products.unitcost]
                //Lambda表达式返回数据
                product
            }
        }
        return productList
    }

    override fun create(product: Product) {
        TODO("not implemented")
    }

    override fun modify(product: Product) {
        TODO("not implemented")
    }

    override fun remove(product: Product) {
        TODO("not implemented")
    }

}