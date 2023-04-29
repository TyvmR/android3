package com.zhijieketang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {


            GlobalScope.launch {                      // 创建一并启动个协程在后台执行
                delay(1000L)                // 非阻塞延迟1秒
                println("World！")            // 协程打印
                println("协程结束。")
            }
            println("Hello，")                // 主线程打印
            Thread.sleep(5000L)                 // 主线程被阻塞5秒
            println("主线程继续...")
        }

    }
}