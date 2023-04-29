package com.zhijieketang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Button
import android.widget.EditText

// 设置实例标签

const val TAG = "loginsample"

class MainActivity : Activity() {

    private var txtUserid: EditText? = null
    private var txtPwd: EditText? = null
    private var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "调用MainActivity|onCreate函数")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.button_login)
        txtUserid = findViewById(R.id.editText_userid)
        txtPwd = findViewById(R.id.editText_password)

        btnLogin?.setOnClickListener() {

            if (txtUserid?.text.toString() == "tony"
                && txtPwd?.text.toString() == "123"
            ) {
                println("登录成功！")
                // 定义意图
                val it = Intent(
                    this, SuccessActivity::class.java
                )

                // 设置参数
                it.putExtra("userid", txtUserid?.text.toString())
                // 启动SuccessActivity活动
                startActivity(it)
            } else {
                println("登录失败！")
                // 定义意图
                val it = Intent(
                    this, FailureActivity::class.java
                )
                // 跳转FailureActivity活动
                startActivity(it)

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "调用MainActivity|onDestroy函数")
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG, "调用MainActivity|onPause函数")
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "调用MainActivity|onRestart函数")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "调用MainActivity|onResume函数")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "调用MainActivity|onStop函数")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "调用MainActivity|onStart函数")
    }
}