package com.zhijieketang

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

// 定义广播类
class SystemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "SystemReceiver调用BroadcastReceiver")
        Toast.makeText(context, "接收到系统广播...", Toast.LENGTH_LONG).show()
        // 接收到系统广播,则启动下载服务
        val it = Intent(context, DownloadService::class.java)
        context.startService(it)
    }
}
