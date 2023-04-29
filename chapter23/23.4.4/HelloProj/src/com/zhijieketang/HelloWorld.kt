/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang


import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingConstants

class MyFrame(title: String) : JFrame(title) {

    init {

        //设置窗口大小不变的
        isResizable = false

        // 不设置布局管理器
        layout = null

        // 创建标签
        val label = JLabel("Label")
        // 设置标签的位置和大小
        label.setBounds(89, 13, 100, 30)
        // 设置标签文本水平居中
        label.horizontalAlignment = SwingConstants.CENTER
        // 添加标签到内容面板
        contentPane.add(label)

        // 创建Button1
        val button1 = JButton("Button1")
        // 设置Button1的位置和大小
        button1.setBounds(89, 59, 100, 30)
        // 添加Button1到内容面板
        contentPane.add(button1)

        // 创建Button2
        val button2 = JButton("Button2")
        // 设置Button2的位置
        button2.setLocation(89, 102)
        // 设置Button2的大小
        button2.setSize(100, 30)
        // 添加Button2到内容面板
        contentPane.add(button2)

        // 设置窗口大小
        setSize(300, 200)
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
    MyFrame("不使用布局管理器示例")
}

