package com.zhijieketang

import android.app.Service
import android.content.Intent

import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.v(TAG, "调用MyService-onCreate函数...")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(TAG, "调用MyService-onStartCommand函数... startId = $startId")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.v(TAG, "调用MyService-onDestroy函数...")
    }
}
