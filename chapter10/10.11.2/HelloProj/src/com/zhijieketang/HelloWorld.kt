/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

interface DAOInterface {
    //插入数据
    fun create(): Int

    //查询所有数据
    fun findAll(): Array<Any>?
}

object UserDAO : DAOInterface {
    //保存所有数据属性
    private var datas: Array<Any>? = null

    override fun findAll(): Array<Any>? {
        //TODO 查询所有数据
        return datas
    }

    override fun create(): Int {
//        object Singleton {
//            val x = 10
//        }
        return 0
    }

    object Singleton {
        val x = 10
    }
}

//外部类
class Outer {
    object Singleton {
        val x = 10
    }
}

fun main() {

    UserDAO.create()
    var datas = UserDAO.findAll()

    println(UserDAO.Singleton.x)

//    object Singleton {
//        val x = 10
//    }
}

