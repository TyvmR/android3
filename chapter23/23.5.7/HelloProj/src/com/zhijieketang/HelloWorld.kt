/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.awt.BorderLayout
import java.awt.Button
import javax.swing.JFrame

class MyFrame(title: String) : JFrame(title) {

    init {
        // 设置BorderLayout布局
        layout = BorderLayout(10, 10)

        // 添加按钮到容器的North区域
        contentPane.add(Button("NORTH"), BorderLayout.NORTH)
        // 添加按钮到容器的South区域
        contentPane.add(Button("SOUTH"), BorderLayout.SOUTH)
        // 添加按钮到容器的East区域
        contentPane.add(Button("EAST"), BorderLayout.EAST)
        // 添加按钮到容器的West区域
        contentPane.add(Button("WEST"), BorderLayout.WEST)
        // 添加按钮到容器的Center区域
        contentPane.add(Button("CENTER"), BorderLayout.CENTER)

        setSize(300, 300)
        isVisible = true
    }
}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("BorderLayout示例")
}

