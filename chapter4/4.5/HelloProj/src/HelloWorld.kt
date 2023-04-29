/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

import com.zhijieketang.Date  //引入该包下Date类
import com.zhijieketang.add   //引入该包下add函数
//import com.zhijieketang.*   //引入该包下所有内容
//import java.util.Date  //引入该包下Date类

public fun main() {

    val date = Date()
    println(date)
    val now = java.util.Date()
    println(now)

    val totalScore = add(100, 97)
    println(totalScore)
}