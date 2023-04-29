/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {

    FileInputStream("./TestDir/src.zip").use { fis ->
        FileOutputStream("./TestDir/subDir/src.zip").use { fos ->

            //创建字节缓冲输入流
            val bis = fis.buffered()
            //创建字节缓冲输出流
            val bos = fos.buffered()

            // 复制到输出流
            bis.copyTo(bos)
            println("复制完成")
        }
    }
}