package com.zhijieketang

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.v(TAG, "调用onHandleIntent...")
        synchronized(this) {
            try {
                wait((5 * 1000).toLong())
            } catch (e: Exception) {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "调用onDestroy...")
    }

    companion object {
        private const val TAG = "MyIntentService"
    }
}
