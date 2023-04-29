/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//代码文件：HelloProj/src/main/kotlin/HelloWorld.kt

class Animal {

    // 动物年龄
    var age = 1

    // 动物性别
    var sex = false

    // 动物体重
    private val weight = 0.0

    private fun eat() {
        // 函数体
    }

    fun run(): Int {
        // 函数体
        return 10
    }
}


fun main() {
    val animal = Animal()
    println(animal.run())

}
