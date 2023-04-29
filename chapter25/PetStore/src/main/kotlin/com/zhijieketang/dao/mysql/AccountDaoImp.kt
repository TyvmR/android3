/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/mysql/AccountDaoImp.kt
package com.zhijieketang.dao.mysql

import com.zhijieketang.dao.Account
import com.zhijieketang.dao.AccountDao
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

//用户管理DAO
class AccountDaoImp : AccountDao {

    override fun findAll(): List<Account> {
        TODO("not implemented")
    }

    override fun findById(userid: String): Account? {
        var accountList: List<Account> = emptyList()
        //连接数据库
        Database.connect(URL, user = DB_USER, password = DB_PASSWORD, driver = DRIVER_CLASS)
        //操作数据库
        transaction {
            //添加SQL日志
            addLogger(StdOutSqlLogger)
            //按照主键查询
            accountList = Accounts.select { Accounts.userid.eq(userid) }.map {
                val account = Account()
                account.userid = it[Accounts.userid]
                account.password = it[Accounts.password]
                account.email = it[Accounts.email]
                account.username = it[Accounts.name]
                account.addr = it[Accounts.addr]
                account.city = it[Accounts.city]
                account.country = it[Accounts.country]
                account.phone = it[Accounts.phone]
                //Lambda表达式返回数据
                account
            }
        }
        return if (accountList.isEmpty()) null else accountList.first()
    }

    override fun create(account: Account) {
        TODO("not implemented")
    }

    override fun modify(account: Account) {
        TODO("not implemented")
    }

    override fun remove(account: Account) {
        TODO("not implemented")
    }

}
