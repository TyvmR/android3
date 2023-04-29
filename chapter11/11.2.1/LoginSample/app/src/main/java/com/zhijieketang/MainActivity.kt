package com.zhijieketang

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
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


                // 创建一个意图
                val it = Intent()
/*
               //（2）setClassName设置目标组件
                // 使用方法设置组件
                it.setComponent(
                    ComponentName(
                        "com.zhijieketang",
                        "com.zhijieketang.SuccessActivity"
                    )
                )
                // 使用属性设置组件
                it.component = ComponentName(
                    "com.zhijieketang",
                    "com.zhijieketang.SuccessActivity"
                )*/

/*                // （2）setClassName设置目标组件

                it.setClassName(
                    this,
                    "com.zhijieketang.SuccessActivity"
                )
                // 将数据参数放到意图中
                it.putExtra("userid", txtUserid?.text.toString())*/


                // （3）setClass(packageContext, cls) 是设置目标组件
                it.setClass(this, SuccessActivity::class.java)

                // 将数据参数放到意图中
                it.putExtra("userid", txtUserid?.text.toString())


                // 跳转SuccessActivity活动
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