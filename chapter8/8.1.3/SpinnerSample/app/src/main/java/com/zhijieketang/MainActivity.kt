package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

val COLORS = arrayOf("红色", "橙色", "黄色", "绿色", "蓝色", "紫色")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<CharSequence>(
            this,
            android.R.layout.simple_spinner_item, COLORS
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter

        // 注册事件ItemSelected监听器
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                println("选择了选项:${adapter.getItem(position)}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("未选中")
            }

        }
    }
}