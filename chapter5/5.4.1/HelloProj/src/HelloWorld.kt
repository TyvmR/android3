/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//介绍可空类型

fun main() {

//    var n: Int = 10  //声明Int类型变量
//    n = null      //不能接收空值（null）

    var n: Int? = 10  //声明Int?（Int可空）类型变量
    println(n)
    n = null          //可以接收空值（null）
    println(n)
}
