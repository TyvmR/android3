/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.awt.Button
import java.awt.GridLayout
import javax.swing.JFrame

class MyFrame(title: String) : JFrame(title) {

    init {

        // 设置3行3列的GridLayout布局管理器
        layout = GridLayout(3, 3)

        // 添加按钮到第一行的第一格
        contentPane.add(Button("1"))
        // 添加按钮到第一行的第二格
        contentPane.add(Button("2"))
        // 添加按钮到第一行的第三格
        contentPane.add(Button("3"))
        // 添加按钮到第二行的第一格
        contentPane.add(Button("4"))
        // 添加按钮到第二行的第二格
        contentPane.add(Button("5"))
        // 添加按钮到第二行的第三格
        contentPane.add(Button("6"))
        // 添加按钮到第三行的第一格
        contentPane.add(Button("7"))
        // 添加按钮到第三行的第二格
        contentPane.add(Button("8"))
        // 添加按钮到第三行的第三格
        contentPane.add(Button("9"))

        setSize(400, 400)
        isVisible = true
    }

}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("GridLayout示例")
}
