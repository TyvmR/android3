/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/ui/MyFrame.kt
package com.zhijieketang.ui

import java.awt.Toolkit
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame

//这是一个屏幕居中的自定义窗口
open class MyFrame(title: String, width: Int, height: Int) : JFrame(title) {

    // 获得当前屏幕的宽
    private val screenWidth = Toolkit.getDefaultToolkit().screenSize.getWidth()
    // 获得当前屏幕的高
    private val screenHeight = Toolkit.getDefaultToolkit().screenSize.getHeight()

    init {

        // 设置窗口大小
        setSize(width, height)
        // 计算窗口位于屏幕中心的坐标
        val x = (screenWidth - width).toInt() / 2
        val y = (screenHeight - height).toInt() / 2
        // 设置窗口位于屏幕中心
        setLocation(x, y)

        // 注册窗口事件
        addWindowListener(object : WindowAdapter() {
            // 单击窗口关闭按钮时调用
            override fun windowClosing(e: WindowEvent) {
                // 退出系统
                System.exit(0)
            }
        })
    }
}
