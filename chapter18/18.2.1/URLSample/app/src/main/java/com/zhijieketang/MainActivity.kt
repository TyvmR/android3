package com.zhijieketang

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


const val TAG = "URLSample"

//Web服务网址
const val URL_STR = "http://192.168.0.189:8080/NoteWebService/note.do?action=query"

class MainActivity : AppCompatActivity() {
    private var mTextViewText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextViewText = findViewById(R.id.textView_text)
        val mButtonGO = findViewById<Button>(R.id.button_go)

        mButtonGO.setOnClickListener {
            // IO调度器
            val bgDispatcher: CoroutineDispatcher = Dispatchers.IO
            // 启动协程
            GlobalScope.launch(bgDispatcher) {  // 后台线程调度器
                //调用Notes Web服务
                requestNotes()
            }
        }
    }

    //调用Notes Web服务
    private fun requestNotes() {
        val reqURL = URL(URL_STR)
        //打开网络通信输入流
        reqURL.openStream().use { input ->
            //通过is创建InputStreamReader对象
            val isr = InputStreamReader(input, "utf-8")
            //通过isr创建BufferedReader对象
            val br = BufferedReader(isr)
            val resultString = br.readText()
            //日志输出
            Log.i(TAG, resultString)


            val uiDispatcher = Dispatchers.Main
            // 启动协程
            GlobalScope.launch(uiDispatcher) { // 主线程调度器

                mTextViewText?.text = resultString
            }
        }
    }
}

