/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.io.FileReader
import java.io.FileWriter

fun main() {
    FileReader("./TestDir/JButtonGroup.html").use { fis ->
        FileWriter("./TestDir/subDir/JButtonGroup.html").use { fos ->

            //创建字符缓冲输入流
            val bis = fis.buffered()
            //创建字符缓冲输出流
            val bos = fos.buffered()

            // 复制到输出流
            bis.copyTo(bos)

//            //读取输入流中数据到一个List集合
//            val list = bis.readLines()
//
//            //读取输入流中数据到字符串中
//            val str = bis.readText()
//            println(str)
//            // 遍历输入流中每一行数据，打印每一行数据
//            bis.forEachLine { println(it) }

            println("复制完成")
        }
    }
}