package com.zhijieketang

import android.content.IntentFilter
import android.net.wifi.WifiManager.WIFI_STATE_CHANGED_ACTION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


const val TAG = "Downloader"

class MainActivity : AppCompatActivity() {

    private var mReceiver = SystemReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 声明过滤器
        val filter = IntentFilter()

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        filter.addAction("android.net.conn.WIFI_STATE_CHANGED")
        // 注册广播接收器
        registerReceiver(mReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 注销广播接收器
        unregisterReceiver(mReceiver)
    }
}