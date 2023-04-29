//代码文件：com/zhijieketang/HelloWorld.kt
package com.zhijieketang

fun main() {
    // f1变量是父类类型，指向实现类实例，发生多态
    val f1: Figure = Triangle("三角形")
    f1.onDraw()
    f1.display()

    // f2变量是父类类型，指向实现类实例，发生多态
    val f2: Figure = Ellipse()
    f2.onDraw()
    println(f2.cname)
}