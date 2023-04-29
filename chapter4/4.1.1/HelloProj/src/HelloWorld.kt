/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
public fun main() {

    val `class` = "舞蹈学习班"   //class是硬关键字，前后添加反引号（`），可以用于声明标识符
    val `π` = 3.14159           //Unicode编码，可以用于声明标识符
    var 您好 = "世界"           //Unicode编码，可以用于声明标识符
    var public = "共有的"      //public是修饰符关键字，可以用于声明变量标识符
    println(`class`)
    println(π)

    val it = 100                //it是普通标识符
    val ary = arrayListOf<String>("A", "B", "C")    //创建一个数组
    ary.forEach { println(it) } //it特定标识符
}