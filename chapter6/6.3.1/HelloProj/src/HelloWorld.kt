/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {

    //-----------------------------------
    // 字符串长度length和字符串缓冲区容量capacity
    val sbuilder1 = StringBuilder()
    println("字符串长度：" + sbuilder1.length)
    println("字符串容量：" + sbuilder1.capacity())

    val sbuilder2 = StringBuilder("Hello")
    println("字符串长度：" + sbuilder2.length)
    println("字符串容量：" + sbuilder2.capacity())

    // 字符串缓冲区初始容量是16，超过之后会扩容
    val sbuilder3 = StringBuilder()
    for (i in 0..16) {
        sbuilder3.append(8)
    }
    println("字符串长度：" + sbuilder3.length)
    println("字符串容量：" + sbuilder3.capacity())

}