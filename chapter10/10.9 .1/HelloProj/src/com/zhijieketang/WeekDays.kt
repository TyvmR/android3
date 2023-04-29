/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：com/zhijieketang/WeekDays.kt
package com.zhijieketang

//最简单形式的枚举类
/*enum class WeekDays {
    // 枚举常量列表
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}*/

//枚举类构造函数
enum class WeekDays(
    private val wname: String,
    private val index: Int
) {
    // 枚举常量列表
    MONDAY("星期一", 0), TUESDAY("星期二", 1), WEDNESDAY("星期三", 2), THURSDAY("星期四", 3), FRIDAY("星期五", 4);

    // 重写父类中的toString()函数
    override fun toString(): String {
        return "$wname-$index"
    }
}

