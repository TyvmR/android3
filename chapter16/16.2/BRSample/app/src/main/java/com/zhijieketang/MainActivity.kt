package com.zhijieketang

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


const val TAG = "BRSample"
private const val ACTION_APP_BROADCAST = "com.zhijieketang.MyBroadcastReceiver"
private const val ACTION_APP_INNER_BROADCAST = "com.zhijieketang.MyInnerBroadcastReceiver"


class MainActivity : AppCompatActivity() {
    private var mReceiver1: BroadcastReceiver? = null

    // 声明内部广播
    private val mReceiver2: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "您的内部广播接收器接收了广播",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mReceiver1 = MyBroadcastReceiver()

        val filter1 = IntentFilter()
        filter1.addAction(ACTION_APP_BROADCAST)
        // 注册广播接收器
        registerReceiver(mReceiver1, filter1)

        val filter2 = IntentFilter()
        filter2.addAction(ACTION_APP_INNER_BROADCAST)
        // 注册内部广播器
        registerReceiver(mReceiver2, filter2)

        // 创建2个按钮控制服务
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent()
            intent.action = ACTION_APP_BROADCAST
            // 发送广播
            sendBroadcast(intent)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent()
            intent.action = ACTION_APP_INNER_BROADCAST
            // 发送广播
            sendBroadcast(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 注销广播接收器
        unregisterReceiver(mReceiver1)
        unregisterReceiver(mReceiver2)
    }
}