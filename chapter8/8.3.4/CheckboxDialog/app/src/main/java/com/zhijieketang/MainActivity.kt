package com.zhijieketang

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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

    //初始化显示时选中情况
    var selectedList = booleanArrayOf(
        false, true, false, true, false,
        false, false
    )

    //单击button事件处理
    override fun onClick(v: View?) {
        val dialog = AlertDialog.Builder(this)
            .setIcon(R.mipmap.globe)
            .setTitle(R.string.radiodialog)
            .setMultiChoiceItems(
                R.array.Radio_dialog_items,
                selectedList,
                object : DialogInterface.OnMultiChoiceClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {

                        //保存选项状态
                        selectedList[which] = isChecked
                    }
                }
            )

            .setPositiveButton(
                R.string.confirm
            ) { dialog, which ->
                //从资源文件dialog_items获得数组
                val items = resources.getStringArray(R.array.Radio_dialog_items)
                //被选择的洲名
                val selected = mutableListOf<String>()

                for (idx in selectedList.indices) {
                    if (selectedList[idx]) {
                        selected.add(items[idx])
                    }
                }
                Toast.makeText(
                    this,
                    "你选择的位置是: $selected",
                    Toast.LENGTH_LONG
                ).show()
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