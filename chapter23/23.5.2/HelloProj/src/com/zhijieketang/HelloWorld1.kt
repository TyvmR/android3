/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld1.kt

package com.zhijieketang


import java.awt.BorderLayout
import javax.swing.*


class MyFrame(title: String) : JFrame(title) {

    private val textField: JTextField
    private val passwordField: JPasswordField

    init {
        // 创建一个面板panel1放置TextField和Password
        val panel1 = JPanel()
        // 将面板panel1添加到内容视图
        contentPane.add(panel1, BorderLayout.NORTH)

        // 创建标签
        val lblTextFieldLabel = JLabel("TextField:")
        // 添加标签到面板panel1
        panel1.add(lblTextFieldLabel)

        // 创建文本框
        textField = JTextField(12)
        // 添加文本框到面板panel1
        panel1.add(textField)

        // 创建标签
        val lblPasswordLabel = JLabel("Password:")
        // 添加标签面板panel1
        panel1.add(lblPasswordLabel)

        // 创建密码框
        passwordField = JPasswordField(12)
        // 添加密码框到面板panel1
        panel1.add(passwordField)

        // 创建一个面板panel2放置TextArea
        val panel2 = JPanel()
        contentPane.add(panel2, BorderLayout.SOUTH)

        // 创建标签
        val lblTextAreaLabel = JLabel("TextArea:")
        // 添加标签到面板panel2
        panel2.add(lblTextAreaLabel)

        // 创建文本区
        val textArea = JTextArea(3, 20)
        // 添加文本区到面板panel2
        panel2.add(textArea)

        // 设置窗口大小
        pack()    // 紧凑排列，其作用相当于setSize()

        // 设置窗口可见
        isVisible = true

        textField.addActionListener { textArea.text = "在文本框上按下Enter键" }
    }
}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("文本输入组件")
}
