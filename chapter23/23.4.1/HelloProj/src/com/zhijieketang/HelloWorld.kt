/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

class MyFrame(title: String) : JFrame(title) {

    // 声明标签
    private val label: JLabel

    init {

        layout = FlowLayout(FlowLayout.LEFT, 20, 20)
        // 创建标签
        label = JLabel("Label")
        // 添加标签到内容面板
        contentPane.add(label)

        // 创建Button1
        val button1 = JButton("Button1")
        // 添加Button1到内容面板
        contentPane.add(button1)

        // 创建Button2
        val button2 = JButton("Button2")
        // 添加Button2到内容面板
        contentPane.add(button2)

        // 设置窗口大小
        setSize(350, 120)
        // 设置窗口可见
        isVisible = true

        // 注册事件监听器，监听Button2单击事件
        button2.addActionListener { label.text = "Hello Swing!" }
        // 注册事件监听器，监听Button1单击事件
        button1.addActionListener { label.text = "Hello World!" }
    }
}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("FlowLayout示例")
}

