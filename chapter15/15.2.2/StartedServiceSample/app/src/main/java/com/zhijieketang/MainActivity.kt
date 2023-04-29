package com.zhijieketang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


const val TAG = "StartedServiceSample"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 创建2个按钮控制服务
        val btnStart = findViewById<Button>(R.id.button_start)
        val btnStop = findViewById<Button>(R.id.button_stop)

        // 响应开始按钮单击事件
        btnStart.setOnClickListener {
            // 通过Intent来启动
            val serviceIntent = Intent(this, MyService::class.java)
            startService(serviceIntent)
        }
        // 响应停止按钮单击事件
        btnStop.setOnClickListener {
            // 通过Intent来停止
            val serviceIntent = Intent(this, MyService::class.java)
            stopService(serviceIntent)
        }
    }
}