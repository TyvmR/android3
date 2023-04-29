package com.zhijieketang

import android.Manifest
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


const val TAG = "Downloader"
class MainActivity : AppCompatActivity() {

    private var mReceiver = SystemReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 请求授权
        checkPermissions()

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


    // 核对权限，并请求授权
    fun checkPermissions() {
        // 1、检查是否权限
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            // 请求的权限集合
            val permissions = arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
            )
            // 2、请求授权，弹出对话框
            requestPermissions(permissions, 0)
        }
    }
}