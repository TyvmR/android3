/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt


fun main() {
    val s1 = "Hello World"
    val s2 = "\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064"

    val s3 = "Hello \nWorld"
    val s4 = """Hello \nWorld"""

    val s5 = """Hello 
        
                World"""

    println("s1 = " + s1)
    println("s2 = " + s2)
    println("s3 = " + s3)
    println("s4 = " + s4)
    println("s5 = " + s5)

}