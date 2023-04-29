/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld1.kt

package com.zhijieketang


import javax.swing.*

class MyFrame(title: String) : JFrame(title) {

    // 用于标签切换的图标
    private val images = arrayOf<Icon>(
        ImageIcon("./icon/0.png"),
        ImageIcon("./icon/1.png"),
        ImageIcon("./icon/2.png"),
        ImageIcon("./icon/3.png"),
        ImageIcon("./icon/4.png"),
        ImageIcon("./icon/5.png")
    )

    // 当前页索引
    private var currentPage = 0

    init {

        // 设置窗口大小不变的
        isResizable = false

        // 不设置布局管理器
        layout = null

        // 创建标签
        val label = JLabel(images[0])
        // 设置标签的位置和大小
        label.setBounds(94, 27, 100, 50)
        // 设置标签文本水平居中
        label.horizontalAlignment = SwingConstants.CENTER
        // 添加标签到内容面板
        contentPane.add(label)

        // 创建向后翻页按钮
        val backButton = JButton(ImageIcon("./icon/ic_menu_back.png"))
        // 设置按钮的位置和大小
        backButton.setBounds(77, 90, 47, 30)
        // 添加按钮到内容面板
        contentPane.add(backButton)

        // 创建向前翻页按钮
        val forwardButton = JButton(ImageIcon("./icon/ic_menu_forward.png"))
        // 设置按钮的位置和大小
        forwardButton.setBounds(179, 90, 47, 30)
        // 添加按钮到内容面板
        contentPane.add(forwardButton)

        // 设置窗口大小
        setSize(300, 200)
        // 设置窗口可见
        isVisible = true

        // 注册事件监听器，监听向后翻页按钮单击事件
        backButton.addActionListener {
            if (currentPage < images.size - 1) {
                currentPage++
            }
            label.icon = images[currentPage]
        }

        // 注册事件监听器，监听向前翻页按钮单击事件
        forwardButton.addActionListener {
            if (currentPage > 0) {
                currentPage--
            }
            label.icon = images[currentPage]
        }
    }
}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("标签和按钮")
}
