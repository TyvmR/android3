package com.zhijieketang

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


const val TAG = "VideoPlayer"


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 请求授权
        checkPermissions()
        val videoView = findViewById<VideoView>(R.id.videoview)

        val sdCardDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val path = "${sdCardDir?.path}/test.mp4"
        val uri = Uri.parse(path)

        // 创建MediaController
        val mc = MediaController(this)
        // 设置VideoView
        videoView.setMediaController(mc)

        videoView.setOnCompletionListener {
            Toast.makeText(this, "播放完成了", Toast.LENGTH_SHORT).show()
        }
        // 设置播放文件路径
        videoView.setVideoURI(uri)
        videoView.start()
    }

    // 核对权限，并请求授权
    private fun checkPermissions() {
        // 1、检查是否权限
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // 请求的权限集合
            val permissions = arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
            )
            // 2、请求授权，弹出对话框
            requestPermissions(permissions, 0)
        }
    }
}
