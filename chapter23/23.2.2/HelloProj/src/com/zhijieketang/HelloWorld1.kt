/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld1.kt

package com.zhijieketang

import javax.swing.JFrame
import javax.swing.JLabel

fun main() {
    // 创建窗口对象
    val frame = JFrame("MyFrame")

    // 创建Label
    val label = JLabel("Hello Swing！")
    // 获得窗口的内容面板
    val pane = frame.contentPane
    // 添加Label到内容面板
    pane.add(label)

    // 设置窗口大小
    frame.setSize(300, 300)
    // 设置窗口可见
    frame.isVisible = true
}
