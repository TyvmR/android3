import java.awt.GridLayout
import java.awt.event.ItemEvent
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingConstants

/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/

//Kotlin代码文件：HelloProj/src/com/zhijieketang/HelloWorld.kt

class MyFrame(title: String) : JFrame(title) {

    private val s1 = arrayOf("Java", "C++", "Objective-C")
    private val s2 = arrayOf("男", "女")

    // 声明下拉列表JComboBox
    private val choice1 = JComboBox(s1)
    private val choice2 = JComboBox(s2)

    init {

        layout = GridLayout(2, 2, 0, 0)
        // 创建标签
        val lblTextFieldLabel = JLabel("选择你喜欢的编程语言：")
        lblTextFieldLabel.horizontalAlignment = SwingConstants.RIGHT
        contentPane.add(lblTextFieldLabel)

        // 注册Action事件侦听器，采用Lambda表达式
        choice1.addActionListener { e ->
            val cb = e.source as JComboBox<String>
            // 获得选择的项目
            val itemString = cb.selectedItem as String
            println(itemString)
        }
        contentPane.add(choice1)

        // 创建标签
        val lblTextAreaLabel = JLabel("选择性别：")
        lblTextAreaLabel.horizontalAlignment = SwingConstants.RIGHT
        contentPane.add(lblTextAreaLabel)

        // 注册项目选择事件侦听器
        choice2.addItemListener { e ->
            // 项目选择
            if (e.stateChange == ItemEvent.SELECTED) {
                // 获得选择的项目
                val itemString = e.item as String
                println(itemString)
            }
        }
        contentPane.add(choice2)
        // 设置窗口大小
        setSize(400, 150)
        // 设置窗口可见
        isVisible = true
    }

}

// 主函数
fun main() {
    //创建Frame对象
    MyFrame("下拉列表示例")
}
