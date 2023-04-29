package com.zhijieketang

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zhijieketang.BinderService.LocalBinder
import java.util.*


const val TAG = "StartedServiceSample"

class MainActivity : AppCompatActivity() {

    //绑定的服务
    var mService: BinderService? = null

    //绑定状态
    var mBound = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCall1 = findViewById<Button>(R.id.button_call1)
        // 调用BinderService中的方法
        btnCall1.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        val btnCall2 = findViewById<Button>(R.id.button_call2)
        // 调用BinderService中的方法
        btnCall1.setOnClickListener {
            val intent = Intent(this, MyIntentService::class.java)
            startService(intent)
        }
    }
}