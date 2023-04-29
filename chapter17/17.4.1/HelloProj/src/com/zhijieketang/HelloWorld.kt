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
    val date = readDate()
    println("读取的日期  = $date")
}

private fun readDate(): Date? {

    var fileis: FileInputStream? = null
    var isr: InputStreamReader? = null
    var br: BufferedReader? = null

    try {
        fileis = FileInputStream("readme.txt")
        isr = InputStreamReader(fileis)
        br = BufferedReader(isr)
        // 读取文件中的一行数据
        val str = br.readLine() ?: return null

        val df = SimpleDateFormat("yyyy-MM-dd")
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
    } finally {
        try {
            if (fileis != null) {
                fileis.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            if (isr != null) {
                isr.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            if (br != null) {
                br.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return null
}
