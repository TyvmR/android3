/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：QQ/src/main/kotlin/com/zhijieketang/server/UserDAO.kt
package com.zhijieketang.server

import com.zhijieketang.server.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserDAO {

    // 按照主键查询
    fun findById(id: String): Map<String, Any>? {

        var list: List<Map<String, String>> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            list = Users.select { Users.user_id.eq(id) }.map {
                val row = mutableMapOf<String, String>()
                row["user_id"] = it[Users.user_id]
                row["user_pwd"] = it[Users.user_pwd]
                row["user_name"] = it[Users.user_name]
                row["user_icon"] = it[Users.user_icon]
                //Lambda表达式返回数据
                row
            }
        }
        return if (list.isEmpty()) null else list.first()
    }

    // 查询好友 列表
    fun findFriends(id: String): List<Map<String, Any>>? {

        var list: List<Map<String, String>> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            val userList1 = Friends.slice(Friends.user_id2).select {
                Friends.user_id1.eq(id)
            }.map {
                it[Friends.user_id2]
            }

            val userList2 = Friends.slice(Friends.user_id1).select {
                Friends.user_id2.eq(id)
            }.map {
                it[Friends.user_id1]
            }

            list = Users.select {
                Users.user_id.inList(userList1 + userList2)
            }.map {
                val row = mutableMapOf<String, String>()
                row["user_id"] = it[Users.user_id]
                row["user_pwd"] = it[Users.user_pwd]
                row["user_name"] = it[Users.user_name]
                row["user_icon"] = it[Users.user_icon]
                //Lambda表达式返回数据
                row
            }
        }
        return list
    }
}
