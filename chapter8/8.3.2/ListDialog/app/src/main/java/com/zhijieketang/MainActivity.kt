package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.widget.Button
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
        val dialog = AlertDialog.Builder(this)
            .setTitle(R.string.selectdialog)
            .setItems(   //设置对话框列表
                R.array.select_dialog_items
            ) { dialog, which ->

                val items = resources.getStringArray(R.array.select_dialog_items)
                makeText(this, "你选择的位置是: ${which},你选择的洲是: ${items[which]}", LENGTH_SHORT).show()
            }
            .create()
        dialog.show()
    }
}