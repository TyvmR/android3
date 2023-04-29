/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang


import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

// 声明部门表
object Departments : IntIdTable() {
    //声明表中字段
    val name = varchar("name", length = 30)
}

// 声明部门实体
class Department(id: EntityID<Int>) : IntEntity(id) {
    //为数据表Departments与实体Department建立映射关系
    companion object : IntEntityClass<Department>(Departments)

    var name by Departments.name
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

        //部门实体中插入数据
        Department.new {
            name = "销售部"
        }

        val dept = Department.new {
            name = "技术部"
        }
        showDatas()

        //修改部门实体属性
        dept.name = "市场部"
        showDatas()

        //删除部门实体
        dept.delete()
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