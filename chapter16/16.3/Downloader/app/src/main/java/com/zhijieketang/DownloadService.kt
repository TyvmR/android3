package com.zhijieketang

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.*
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*


// 下载服务
class DownloadService : Service() {
    // 控制协程停止变量
    private var isRunning = true
    var connectivityManager: ConnectivityManager? = null

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            Log.i(TAG, "网络可用...")
            // 开始工作
            downloadJob()


        }

        override fun onLost(network: Network) {
            super.onLost(network)
            Log.i(TAG, "网络断开...")
            isRunning = false
            // 停止工作

        }

    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onCreate() {
        Log.d(TAG, "调用DownloadService-onCreate函数...")
        connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        val request = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        // 注册网络回调函数
        connectivityManager?.registerNetworkCallback(request, networkCallback)
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "调用DownloadService-onStartCommand函数... startId = $startId")

        return super.onStartCommand(intent, flags, startId)
    }


    override fun onDestroy() {
        connectivityManager?.unregisterNetworkCallback(networkCallback)
    }

    // 下载工作函数
    fun downloadJob() {
        // IO调度器
        val bgDispatcher: CoroutineDispatcher = Dispatchers.IO

        // 启动下载协程
        GlobalScope.launch(bgDispatcher) {

            while (isRunning) {            // 协程执行任务
                delay(5000L)            // 非阻塞延迟5秒
                Log.i(TAG, "下载中...")
                // TODO 执行下载任务
            }
            Log.i(TAG, "下载协程结束。")

        }
    }
}