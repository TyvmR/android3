/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.io.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val date = readDateFromFile()
    println("读取的日期  = $date")
}

private fun readDateFromFile(): Date? {

    val df = SimpleDateFormat("yyyy-MM-dd")

    try {
        val fileis = FileInputStream("readme.txt")
        val isr = InputStreamReader(fileis)
        val br = BufferedReader(isr)
        // 读取文件中的一行数据
        val str = br.readLine() ?: return null
        return df.parse(str)

    } catch (e: FileNotFoundException) {
        println("处理FileNotFoundException...")
        e.printStackTrace()
    } catch (e: IOException) {
        println("处理IOException...")
        e.printStackTrace()
    } catch (e: ParseException) {
        println("处理ParseException...")
        e.printStackTrace()
    }

    return null
}