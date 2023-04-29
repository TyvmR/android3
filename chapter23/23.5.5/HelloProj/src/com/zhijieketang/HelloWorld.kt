/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.ListSelectionModel

class MyFrame(title: String) : JFrame(title) {

    private val s1 = arrayOf("Java", "C++", "Objective-C")

    init {
        // 创建标签
        val lblTextFieldLabel = JLabel("选择你喜欢的编程语言：")
        contentPane.add(lblTextFieldLabel, BorderLayout.NORTH)

        // 列表组件JList
        val list1 = JList(s1)
        list1.selectionMode = ListSelectionModel.SINGLE_SELECTION
        // 注册项目选择事件侦听器，采用Lambda表达式。
        list1.addListSelectionListener { e ->
            if (!e.valueIsAdjusting) {
                // 获得选择的内容
                val itemString = list1.selectedValue as String
                println(itemString)
            }
        }
        contentPane.add(list1, BorderLayout.CENTER)

        // 设置窗口大小
        setSize(300, 200)
        // 设置窗口可见
        isVisible = true
    }

}


// 主函数
fun main() {
    //创建Frame对象
    MyFrame("列表示例")
}

