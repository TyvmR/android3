package com.zhijieketang

import android.app.Activity
import android.os.Bundle
import android.util.Log

// 活动标签
const val TAG = "HelloAndroid"

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "调用MainActivity|onCreate函数")
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