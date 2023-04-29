/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    val chars = charArrayOf('a', 'b', 'c', 'd', 'e')  //创建字符数组

    val s1 = String(chars)                      // 通过字符数组获得字符串对象
    val s2 = String(chars, 1, 4) // 通过子字符数组获得字符串对象
    println("s1 = " + s1)  //输出结果s1 = abcde
    println("s2 = " + s2)  //输出结果s2 = bcde

    val bytes = byteArrayOf(97, 98, 99)     //创建字节数组
    val s3 = String(bytes)                      // 通过字节数组获得字符串对象
    val s4 = String(bytes, 1, 2) // 通过子字节数组获得字符串对象
    println("s3 = " + s3)   //输出结果s3 = abc
    println("s4 = " + s4)   //输出结果s4 = bc

}