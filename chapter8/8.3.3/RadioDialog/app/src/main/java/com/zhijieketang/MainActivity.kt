package com.zhijieketang

import android.content.DialogInterface
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
            .setIcon(R.mipmap.globe)

            .setTitle(R.string.radiodialog)
            .setSingleChoiceItems(
                R.array.Radio_dialog_items, 0
            ) { dialog, which ->
                val items = resources.getStringArray(R.array.Radio_dialog_items)
                val locationname = items[which]
                Toast.makeText(this, locationname, LENGTH_LONG).show()
            }

            .setPositiveButton(
                R.string.confirm
            ) { dialog, which ->
                makeText(this, "你点击了确定按钮", LENGTH_SHORT).show()
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