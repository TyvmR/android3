/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//代码文件：PetStore/src/main/kotlin/com/zhijieketang/ui/LoginFrame.kt
package com.zhijieketang.ui

import com.zhijieketang.UserSession
import com.zhijieketang.dao.mysql.AccountDaoImp
import java.awt.Font
import java.util.*
import javax.swing.*

//用户登录窗口
class LoginFrame : MyFrame("用户登录", 400, 230) {

    // private val txtAccountId: JTextField
    // private val txtPassword: JPasswordField

    init {
        // 设置布局管理为绝对布局
        layout = null

        with(JLabel()) {
            horizontalAlignment = SwingConstants.RIGHT
            setBounds(51, 33, 83, 30)
            text = "账号："
            font = Font("微软雅黑", Font.PLAIN, 15)
            contentPane.add(this)
        }

        val txtAccountId = JTextField(10).apply {
            text = "j2ee"
            setBounds(158, 33, 157, 30)
            font = Font("微软雅黑", Font.PLAIN, 15)
            contentPane.add(this)
        }

        with(JLabel()) {
            text = "密码："
            font = Font("微软雅黑", Font.PLAIN, 15)
            horizontalAlignment = SwingConstants.RIGHT
            setBounds(51, 85, 83, 30)
            contentPane.add(this)
        }

        val txtPassword = JPasswordField(10).apply {
            text = "j2ee"
            setBounds(158, 85, 157, 30)
            contentPane.add(this)
        }

        val btnOk = JButton().apply {
            text = "确定"
            font = Font("微软雅黑", Font.PLAIN, 15)
            setBounds(61, 140, 100, 30)
            contentPane.add(this)
        }

        val btnCancel = JButton().apply {
            text = "取消"
            font = Font("微软雅黑", Font.PLAIN, 15)
            setBounds(225, 140, 100, 30)
            contentPane.add(this)
        }

        // 注册btnOk的ActionEvent事件监听器
        btnOk.addActionListener {
            UserSession.account = AccountDaoImp().findById(txtAccountId.text)

            val passwordText = String(txtPassword.password)
            if (UserSession.account != null && passwordText == UserSession.account!!.password) {
                println("登录成功。")
                UserSession.loginDate = Date()
                ProductListFrame().isVisible = true
                isVisible = false
            } else {
                val label = JLabel("您输入的账号或密码有误，请重新输入。")
                label.font = Font("微软雅黑", Font.PLAIN, 15)
                JOptionPane.showMessageDialog(null, label,
                        "登录失败", JOptionPane.ERROR_MESSAGE)
            }
        }

        // 注册btnCancel的ActionEvent事件监听器
        btnCancel.addActionListener { System.exit(0) }
    }
}
