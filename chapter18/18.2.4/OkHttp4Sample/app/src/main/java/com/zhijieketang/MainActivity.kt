package com.zhijieketang

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


const val TAG = "URLSample"

//Web服务网址
const val URL_STR = "http://192.168.0.189:8080/NoteWebService/note.do"

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

        val client = OkHttpClient()

        //  创建请求表单
        val formBody = FormBody.Builder()
            .add("action", "query")
            .add("ID", "20")
            .build()
        val request = Request.Builder()
            .url(URL_STR)
            .post(formBody)
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("发生异常！ code $response")
            val resultString = response.body!!.string()
            val uiDispatcher = Dispatchers.Main
            // 启动协程
            GlobalScope.launch(uiDispatcher) { // 主线程调度器
                mTextViewText?.text = resultString
            }
        }
    }
}

