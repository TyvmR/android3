package com.zhijieketang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.Button01)
        button.setOnClickListener(this)

    }

    //单击button事件处理
    override fun onClick(v: View?) {
        val factory = LayoutInflater.from(this)
        val textEntryView: View = factory.inflate(R.layout.layoutdialog, null)

        val dialog = AlertDialog.Builder(this)
            .setTitle(R.string.title)
            .setView(textEntryView)
            .setPositiveButton(
                R.string.login
            ) { dialog, which ->


                val user = textEntryView
                    .findViewById<EditText>(R.id.username)
                val pass = textEntryView
                    .findViewById<EditText>(R.id.password)
                makeText(this, "用户名：${user.text}  密码：${pass.text}", LENGTH_SHORT).show()
            }

            .setNegativeButton(
                R.string.cancel,
            ) { dialog, which ->
                makeText(this, "你点击了取消按钮", LENGTH_SHORT).show()
            }

            .create()
        dialog.show()
    }
}