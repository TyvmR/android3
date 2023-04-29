/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：/com/zhijieketang/HelloWorld.kt
package com.zhijieketang

//reduce函数示例

fun main() {
    //计算所有歌曲播放时长之和
    val durations = songs.map { it.durationInSeconds }
        .reduce { acc, i ->
            acc + i
        }
    println(durations) //输出：2566
}

