/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

fun main() {
    val c1 = 'A'
    val c2 = '\u0041'
    val c3: Char = '花'

    println(c1)
    println(c2)
    println(c3)

    //转义符
    //在Hello和World插入制表符
    val specialCharTab1 = "Hello\tWorld."
    //在Hello和World插入制表符，制表符采用Unicode编码\u0009表示
    val specialCharTab2 = "Hello\u0009World."
    //在Hello和World插入换行符
    val specialCharNewLine = "Hello\nWorld."
    //在Hello和World插入双引号
    val specialCharQuotationMark = "Hello\"World\"."
    //在Hello和World插入单引号
    val specialCharApostrophe = "Hello\'World\'."
    //在Hello和World插入反斜杠
    val specialCharReverseSolidus = "Hello\\World."
    //使用退格符
    val specialCharReverseBack = "Hello\bWorld."
    //在Hello和World插入美元符
    val specialCharReverseUSD = "Hello\$World."

    println("水平制表符tab1: $specialCharTab1")
    println("水平制表符tab2: $specialCharTab2")
    println("换行: $specialCharNewLine")
    println("双引号: $specialCharQuotationMark")
    println("单引号: $specialCharApostrophe")
    println("反斜杠: $specialCharReverseSolidus")
    println("退格符: $specialCharReverseBack")
    println("美元符: $specialCharReverseUSD")

}