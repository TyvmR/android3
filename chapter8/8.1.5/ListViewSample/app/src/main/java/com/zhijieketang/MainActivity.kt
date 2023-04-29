package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


val mStrings = arrayOf(
    "北京市", "天津市", "上海", "重庆", "哈尔滨",
    "石家庄", "秦皇岛", "济南", "青岛", "南京", "三亚", "昆明",
    "成都", "长沙", "武汉", "九江", "香港", "澳门"
)


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, mStrings
        )

        val listview = findViewById<ListView>(R.id.ListView01)
        listview.adapter = adapter

        listview.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                println("点击了选项:" + mStrings[position])
            }

        }
    }
}