/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

package com.zhijieketang

import java.awt.BorderLayout
import java.awt.Font
import java.awt.Toolkit
import javax.swing.*
import javax.swing.ListSelectionModel.SINGLE_SELECTION

class MyFrameTable(title: String) : JFrame(title) {

    // 获得当前屏幕的宽高
    private val screenWidth = Toolkit.getDefaultToolkit().screenSize.getWidth()
    private val screenHeight = Toolkit.getDefaultToolkit().screenSize.getHeight()

    private val table: JTable

    // 表格列标题
    private var columnNames = arrayOf("书籍编号", "书籍名称", "作者", "出版社", "出版日期", "库存数量")

    // 表格数据
    private var rowData = arrayOf(
        arrayOf("0036", "高等数学", "李放", "人民邮电出版社", "20000812", 1),
        arrayOf("0004", "FLASH精选", "刘扬", "中国纺织出版社", "19990312", 2),
        arrayOf("0026", "软件工程", "牛田", "经济科学出版社", "20000328", 4),
        arrayOf("0015", "人工智能", "周未", "机械工业出版社", "19991223", 3),
        arrayOf("0037", "南方周末", "邓光明", "南方出版社", "20000923", 3),
        arrayOf("0008", "新概念3", "余智", "外语出版社", "19990723", 2),
        arrayOf("0019", "通讯与网络", "欧阳杰", "机械工业出版社", "20000517", 1),
        arrayOf("0014", "期货分析", "孙宝", "飞鸟出版社", "19991122", 3),
        arrayOf("0023", "经济概论", "思佳", "北京大学出版社", "20000819", 3),
        arrayOf("0017", "计算机理论基础", "戴家", "机械工业出版社", "20000218", 4),
        arrayOf("0002", "汇编语言", "李利光", "北京大学出版社", "19980318", 2),
        arrayOf("0033", "模拟电路", "邓英才", "电子工业出版社", "20000527", 2),
        arrayOf("0011", "南方旅游", "王爱国", "南方出版社", "19990930", 2),
        arrayOf("0039", "黑幕", "李仪", "华光出版社", "20000508", 24),
        arrayOf("0001", "软件工程", "戴国强", "机械工业出版社", "19980528", 2),
        arrayOf("0034", "集邮爱好者", "李云", "人民邮电出版社", "20000630", 1),
        arrayOf("0031", "软件工程", "戴志名", "电子工业出版社", "20000324", 3),
        arrayOf("0030", "数据库及应用", "孙家萧", "清华大学出版社", "20000619", 1),
        arrayOf("0024", "经济与科学", "毛波", "经济科学出版社", "20000923", 2),
        arrayOf("0009", "军事要闻", "张强", "解放军出版社", "19990722", 3),
        arrayOf("0003", "计算机基础", "王飞", "经济科学出版社", "19980218", 1),
        arrayOf("0020", "现代操作系统", "王小国", "机械工业出版社", "20010128", 1),
        arrayOf("0025", "计算机体系结构", "方丹", "机械工业出版社", "20000328", 4),
        arrayOf("0010", "大众生活", "许阳", "电子出版社", "19990819", 3),
        arrayOf("0021", "网络基础", "王大尉", "北京大学出版社", "20000617", 1),
        arrayOf("0006", "世界杯", "柳飞", "世界出版社", "19990412", 2),
        arrayOf("0028", "高级语言程序设计", "寇国华", "清华大学出版社", "20000117", 3),
        arrayOf("0038", "十大旅游胜地", "潭晓明", "南方出版社", "20000403", 2),
        arrayOf("0018", "编译原理", "郑键", "机械工业出版社", "20000415", 2),
        arrayOf("0007", "JAVA程序设计", "张余", "人民邮电出版社", "19990613", 1),
        arrayOf("0013", "幽灵", "钱力华", "华光出版社", "19991008", 1),
        arrayOf("0022", "万紫千红", "丛丽", "北京大学出版社", "20000702", 3),
        arrayOf("0027", "世界语言大观", "候丙辉", "经济科学出版社", "20000814", 2),
        arrayOf("0029", "操作系统概论", "聂元名", "清华大学出版社", "20001028", 1),
        arrayOf("0016", "数据库系统概念", "吴红", "机械工业出版社", "20000328", 3),
        arrayOf("0005", "java基础", "王一", "电子工业出版社", "19990528", 3),
        arrayOf("0032", "SOL使用手册", "贺民", "电子工业出版社", "19990425", 2)
    )

    init {

        table = JTable(rowData, columnNames)
        // 设置表中内容字体
        table.font = Font("微软雅黑", Font.PLAIN, 16)
        // 设置表列标题字体
        table.tableHeader.font = Font("微软雅黑", Font.BOLD, 16)
        // 设置表行高
        table.rowHeight = 40
        // 设置为单行选中模式
        table.setSelectionMode(SINGLE_SELECTION)
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
    //创建Frame对象
    MyFrameTable("表格示例")
}
