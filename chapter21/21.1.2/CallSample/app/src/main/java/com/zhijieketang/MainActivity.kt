package com.zhijieketang

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "CallSample"

//授权请求编码
private const val PERMISSION_REQUEST_CODE = 9

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 核对权限，并请求授权
        // 1、检查是否权限
        if (checkSelfPermission(Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // 请求的权限集合
            val permissions = arrayOf(
                Manifest.permission.CALL_PHONE
            )

            // 2、请求授权，请求授权弹出对话框
            requestPermissions(permissions, PERMISSION_REQUEST_CODE)
            // 已经授权
        } else {
            Log.i(TAG, "  已经授权...")
            // 调用初始化函数
            initPage()

        }
    }


    // 初始化页面
    private fun initPage() {

        val buttonDial = findViewById<Button>(R.id.buttonDial)

        buttonDial.setOnClickListener {
            Log.i(TAG, " 调出拨打电话界面 ... ")
            val telUri: Uri = Uri.parse("tel:100861")
            val it = Intent(Intent.ACTION_DIAL, telUri)
            startActivity(it)
        }

        val buttonCall = findViewById<Button>(R.id.buttonCall)
        buttonCall.setOnClickListener {

            Log.i(TAG, " 直接呼叫电话号码 ... ")
            val callUri: Uri = Uri.parse("tel:100861")
            val it = Intent(Intent.ACTION_CALL, callUri)
            startActivity(it)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {


        if (requestCode == PERMISSION_REQUEST_CODE) {   // 判断请求Code
            // 包含授权成功权限
            if (!grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                Log.i(TAG, "  授权失败...")
            } else {
                Log.i(TAG, "  授权成功...")
                // 调用初始化函数
                initPage()
            }
        }
    }
}
