/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

// 声明部门表
object Departments : Table() {
    //声明表中字段
    val id = integer("id").autoIncrement()
    val name = varchar("name", length = 30)
    override val primaryKey = PrimaryKey(id, name = "PK_DEP_ID")
}

const val URL = "jdbc:mysql://localhost:3306/MyDB?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
const val DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"

fun main() {
    //连接数据库
    Database.connect(URL, user = "root", password = "12345", driver = DRIVER_CLASS)
    //操作数据库
    transaction {
        //创建部门表Departments
        create(Departments)
        //部门表插入数据
        Departments.insert {
            it[name] = "销售部"
        }
        Departments.insert {
            it[name] = "技术部"
        }
        showDatas()

        //更新数据
        Departments.update({ Departments.name eq "销售部" }) {
            it[name] = "市场部"
        }
        showDatas()

        //删除数据
        Departments.deleteWhere { Departments.id lessEq 1 }
        showDatas()
    }
}


//查询所有数据，并打印
fun showDatas() {
    println("---------------------")
    Departments.selectAll().forEach {
        println("${it[Departments.id]}: ${it[Departments.name]}")
    }
}