package com.zhijieketang

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// 定义广播类
class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "您已经接收到了广播",
            Toast.LENGTH_LONG).show()
    }
}
