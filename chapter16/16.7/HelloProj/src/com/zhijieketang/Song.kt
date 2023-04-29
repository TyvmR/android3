/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/Song.kt
package com.zhijieketang

data class Song(val title: String, val durationInSeconds: Int)

//测试使用
val songs = listOf(
    Song("Speak to Me", 90),
    Song("Breathe", 163),
    Song("On he Run", 216),
    Song("Time", 421),
    Song("The Great Gig in the Sky", 276),
    Song("Money", 382),
    Song("Us and Them", 462),
    Song("Any Color You Like", 205),
    Song("Brain Damage", 228),
    Song("Eclipse", 123)
)