/*
 * Created by 画画的程序员
 * 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
 * 邮箱：eorient@sina.com
 *
 */

//Kotlin代码文件：HelloProj/src/main/kotlin/com/zhijieketang/ch20.3.3.kt

@file:JvmName("StaticFieldDemo")
package com.zhijieketang;

import java.util.*

object Singleton {  //Singleton声明对象
    @JvmField
    val x = 10
    lateinit var birthDate: Date

    @JvmStatic
    fun displayX() {
        println(x)
    }
}

class Account {
    companion object {
        //Account伴生对象
        const val interestRate = 0.018

        @JvmStatic
        fun interestBy(amt: Double): Double {
            return interestRate * amt
        }
    }
}

const val MAX_COUNT = 500