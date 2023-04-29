/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/dao/AccountDao.kt
package com.zhijieketang.dao

//用户管理DAO
interface AccountDao {

    // 查询所有的用户信息
    fun findAll(): List<Account>

    // 根据主键查询用户信息
    fun findById(userid: String): Account?

    // 创建用户信息
    fun create(account: Account)

    // 修改用户信息
    fun modify(account: Account)

    // 删除用户信息
    fun remove(account: Account)
}
