package com.zhijieketang

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Environment
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import java.io.File
import java.io.FileOutputStream

//Web服务网址
const val urlString = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png"
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
                // 执行下载任务

                val client = OkHttpClient()
                val request = Request.Builder()
                    .url(urlString)
                    .build()
                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) throw IOException("发生异常！ $response")

                    val sdCardDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                    val downFile = File(sdCardDir, "download.png")
                    val outputStream = FileOutputStream(downFile)

                    outputStream.use {
                        outputStream.write(response.body?.bytes())
                    }
                }
                Log.i(TAG, "下载协程结束。")

            }
        }
    }
}