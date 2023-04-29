package com.zhijieketang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class FailureActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)
        Log.i(TAG, "调用FailureActivity|onCreate函数")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "调用FailureActivity|onDestroy函数")
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG, "调用FailureActivity|onPause函数")
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "调用FailureActivity|onRestart函数")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "调用FailureActivity|OnCreate函数")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "调用FailureActivity|onStop函数")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "调用FailureActivity|onStart函数")
    }
}