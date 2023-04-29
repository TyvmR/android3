package com.zhijieketang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class SuccessActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        Log.i(TAG, "调用SuccessActivity|onCreate函数")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "调用SuccessActivity|onDestroy函数")
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG, "调用SuccessActivity|onPause函数")
    }


    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "调用SuccessActivity|onPause函数")
        Log.i(TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "调用SuccessActivity|onResume函数")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "调用SuccessActivity|onStop函数")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "调用SuccessActivity|onStart函数")
    }
}