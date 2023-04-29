package com.zhijieketang

import android.app.Activity
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.text.DateFormat
import java.util.*


// 设置实例标签

const val TAG = "SharedPreferencesSample"
const val DATE_KEY = "mydate"
const val PREFS_CONF = "config"

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 获得SharedPreferences对象
        val sp = getSharedPreferences(PREFS_CONF, MODE_PRIVATE)

        val btnRead = findViewById<Button>(R.id.button_read)
        // 响应写入按钮事件
        btnRead.setOnClickListener {

            Log.i(TAG, "写入数据")
            // 获得修改SharedPreferences对象
            val editor: Editor = sp.edit()
            val date = Date()  // 获得当前日期时间
            val format = DateFormat.getDateTimeInstance(
                DateFormat.DEFAULT,
                DateFormat.SHORT,
                Locale.getDefault()
            )
            // 将数据放到SharedPreferences对象
            val strdate = format.format(date)
            editor.putString(DATE_KEY, strdate)
            // 确定修改
            editor.commit()
            Toast.makeText(this, "${strdate}写入数据", Toast.LENGTH_LONG).show()
            Log.i(TAG, "读取数据：写入数据")

        }
        // 响应读取按钮事件
        btnRead.setOnClickListener {
            // 读取DATE_KEY键所对应的值
            val strdate: String? = sp.getString(DATE_KEY, "无数据")
            Log.i(TAG, "读取数据：${strdate}")
            Toast.makeText(this, "读取数据：${strdate}", Toast.LENGTH_LONG).show()

        }
    }
}