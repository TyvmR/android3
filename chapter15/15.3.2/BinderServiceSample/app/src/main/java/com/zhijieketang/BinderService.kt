package com.zhijieketang

import android.app.Service
import android.content.Intent
import android.os.Binder

import android.os.IBinder
import android.util.Log
import java.util.*

class BinderService : Service() {


    // Binder对象
    private val mBinder: IBinder = LocalBinder()

    inner class LocalBinder : Binder() {
        val service: BinderService
            get() {
                // 返回服务对象
                return this@BinderService
            }
    }

    override fun onCreate() {
        Log.v(TAG, "调用BinderService-onCreate函数...")
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.v(TAG, "调用BinderService-onBind...")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v(TAG, "调用BinderService-onUnbind...")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.v(TAG, "调用BinderService-onDestroy函数...")
    }

    // 服务中的公有方法
    fun getDate(): Date {
        return Date()
    }
}
