/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//解码JSON对象
//代码文件：/HelloProj/src/main/kotlin/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import com.beust.klaxon.*

fun main() {

    println("-------1. JSON编码过程----------")
    // 1. JSON编码过程
    // {"name":"tony","age":30,"sex":false,"a":[1,3]}
    val jsonObject = json {
        obj("name" to "tony", "age" to 30)
    }
    jsonObject.put("sex", false)

    val list = listOf(1, 3)
    val jsonArray1 = json {
        //array(1, 3)
        array(list)
    }
    jsonObject.put("a", jsonArray1)

    val jsonArray2 = json {
        array(jsonArray1)
    }
    // 编码完成
    println(jsonObject.toJsonString(prettyPrint = true))
    println(jsonArray2.toJsonString())

    println("-------2. JSON解码过程----------")
    // 2. JSON解码过程
    // {"name":"tony", "age":30, "a":[1, 3]}
    // JSON字符串
    val jsonString = """{"name":"tony", "age":30, "a":[1, 3]}"""
//    val parser = Parser()
    val parser = Parser.default()

    val jsonObj = parser.parse(StringBuilder(jsonString)) as JsonObject
    val name = jsonObj.string("name")
    println("name : $name")
    val age = jsonObj.int("age")
    println("age : $age")

    val jsonAry = jsonObj.array<Int>("a") as JsonArray<Int>
    val n1 = jsonAry[0]
    println("数组a第一个元素 : $n1")
    val n2 = jsonAry[1]
    println("数组a第二个元素 : $n2")

}