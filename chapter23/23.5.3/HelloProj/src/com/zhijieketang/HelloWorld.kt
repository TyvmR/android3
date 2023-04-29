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
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import javax.swing.*


class MyFrame(title: String) : JFrame(title), ItemListener {

    //声明并创建RadioButton对象
    private val radioButton1 = JRadioButton("男")
    private val radioButton2 = JRadioButton("女")

    init {
        // 创建一个面板panel1放置TextField和Password
        val panel1 = JPanel()
        val flowLayout1 = panel1.layout as FlowLayout
        flowLayout1.alignment = FlowLayout.LEFT
        // 将面板panel1添加到内容视图
        contentPane.add(panel1, BorderLayout.NORTH)

        // 创建标签
        val lblTextFieldLabel = JLabel("选择你喜欢的编程语言：")
        // 添加标签到面板panel1
        panel1.add(lblTextFieldLabel)

        //创建checkBox1对象
        val checkBox1 = JCheckBox("Java")
        //添加checkBox1到面板panel1
        panel1.add(checkBox1)

        val checkBox2 = JCheckBox("C++")
        //添加checkBox2到面板panel1
        panel1.add(checkBox2)

        val checkBox3 = JCheckBox("Objective-C")
        //注册checkBox3对ActionEvent事件监听
        checkBox3.addActionListener {
            // 打印checkBox3状态
            println(checkBox3.isSelected)
        }
        //添加checkBox3到面板panel1
        panel1.add(checkBox3)

        // 创建一个面板panel2放置TextArea
        val panel2 = JPanel()
        val flowLayout2 = panel2.layout as FlowLayout
        flowLayout2.alignment = FlowLayout.LEFT
        contentPane.add(panel2, BorderLayout.SOUTH)

        // 创建标签
        val lblTextAreaLabel = JLabel("选择性别：")
        // 添加标签到面板panel2
        panel2.add(lblTextAreaLabel)

        //创建ButtonGroup对象
        val buttonGroup = ButtonGroup()
        //添加RadioButton到ButtonGroup对象
        buttonGroup.add(radioButton1)
        buttonGroup.add(radioButton2)

        //添加RadioButton到面板panel2
        panel2.add(radioButton1)
        panel2.add(radioButton2)

        //注册ItemEvent事件监听器
        radioButton1.addItemListener(this)
        radioButton2.addItemListener(this)

        // 设置窗口大小
        pack() // 紧凑排列，其作用相当于setSize()

        // 设置窗口可见
        isVisible = true
    }

    //实现ItemListener接口方法
    override fun itemStateChanged(e: ItemEvent) {
        if (e.stateChange == ItemEvent.SELECTED) {
            val button = e.item as JRadioButton
            println(button.text)
        }
    }
}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("复选框和单选按钮")
}

