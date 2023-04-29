package com.zhijieketang

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// 设置实例标签
const val TAG = "threadsample"

class MainActivity : AppCompatActivity() {

    private var mLabel: TextView? = null
    private var mButton: Button? = null
    private var isRunning = true
    private var mTimer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLabel = findViewById(R.id.textView)
        mButton = findViewById(R.id.button)
        mButton?.setOnClickListener {
            isRunning = false
        }

        // 启动协程
        GlobalScope.launch {

            while (isRunning) {           // 协程执行任务
                delay(1000L)     // 非阻塞延迟1秒
                mTimer++
                val message = "逝去了 $mTimer 秒。"
                println(message)
                mLabel?.text = message
            }
            println("协程结束。")
        }
    }
}
