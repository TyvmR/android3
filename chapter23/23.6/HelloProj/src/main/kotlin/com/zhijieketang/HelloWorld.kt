/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import com.google.gson.Gson
import java.awt.BorderLayout
import java.awt.Font
import java.awt.Toolkit
import java.io.FileReader
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTable
import javax.swing.ListSelectionModel
import javax.swing.ListSelectionModel.SINGLE_SELECTION

class MyFrameTable(
    title: String,
) : JFrame(title) {

    // 获得当前屏幕的宽高
    private val screenWidth = Toolkit.getDefaultToolkit().screenSize.getWidth()
    private val screenHeight = Toolkit.getDefaultToolkit().screenSize.getHeight()

    private val table: JTable

    init {
        val model = BookTableModel()

        table = JTable(model)
        with(table) {
            // 设置表中内容字体
            font = Font("微软雅黑", Font.PLAIN, 16)
            // 设置表列标题字体
            tableHeader.font = Font("微软雅黑", Font.BOLD, 16)
            // 设置表行高
            rowHeight = 40
            // 设置为单行选中模式
            setSelectionMode(SINGLE_SELECTION)
        }
        // 返回当前行的状态模型
        val rowSM = table.selectionModel
        // 注册侦听器，选中行发生更改时触发
        rowSM.addListSelectionListener { e ->
            //只处理鼠标按下
            if (!e.valueIsAdjusting) {
                return@addListSelectionListener
            }
            val lsm = e.source as ListSelectionModel
            if (lsm.isSelectionEmpty) {
                println("没有选中行")
            } else {
                val selectedRow = lsm.minSelectionIndex
                println("第" + selectedRow + "行被选中")
            }
        }

        val scrollPane = JScrollPane()
        scrollPane.setViewportView(table)
        contentPane.add(scrollPane, BorderLayout.CENTER)

        // 设置窗口大小
        setSize(960, 640)
        // 计算窗口位于屏幕中心的坐标
        val x = (screenWidth - 960).toInt() / 2
        val y = (screenHeight - 640).toInt() / 2
        // 设置窗口位于屏幕中心
        setLocation(x, y)
        // 设置窗口可见
        isVisible = true
    }

}


// 主函数
fun main() {
    MyFrameTable("图书库存")
}
