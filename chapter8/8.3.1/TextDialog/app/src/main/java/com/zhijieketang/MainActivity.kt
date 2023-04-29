package com.zhijieketang

import android.content.DialogInterface
import android.content.DialogInterface.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.*
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
        val dialog = AlertDialog.Builder(this)
            .setIcon(R.mipmap.ic_launcher)  //设置对话框图标
            .setTitle("标题")                //设置对话框标题
            .setMessage("文本信息对话框")      //设置对话框显示文本信息
            .setPositiveButton(
                R.string.confirm
            ) { dialog, which ->
                makeText(this, "你点击了确定按钮", LENGTH_SHORT).show()
            }
            .setNeutralButton(
                R.string.other
            ) { dialog, which ->
                makeText(this, "你点击了其他按钮", LENGTH_SHORT).show()
            }
            .setNegativeButton(
                R.string.cancel
            ) { dialog, which ->
                makeText(this, "你点击了取消按钮", LENGTH_SHORT).show()
            }
            .create()
        dialog.show()
    }
}