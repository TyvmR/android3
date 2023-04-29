package com.zhijieketang

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class ModAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_mod)

        val btnOk = findViewById<Button>(R.id.btnok)
        val btnCancel = findViewById<Button>(R.id.btncancel)

        // 单击确定按钮插入数据
        btnOk.setOnClickListener {

            addData()
            finish()
        }
        // 单击取消按钮返回列表界面
        btnCancel.setOnClickListener {
            this.finish()
        }
    }

    // 增加数据函数
    private fun addData() {

        // 准备数据
        val txtInput = findViewById<EditText>(R.id.incontent)
        val content = txtInput.text.toString()

        val urlFormat = "http://%s:%s/NoteWebService/note.do?action=add&content=%s"

        val strUrl = String.format(urlFormat, SER_HOST_IP, SER_HOST_PORT, content)
        val reqURL = URL(strUrl)

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(reqURL)
            .build()

        // IO调度器
        val bgDispatcher: CoroutineDispatcher = Dispatchers.IO
        // 启动协程
        GlobalScope.launch(bgDispatcher) {
            try {
                client.newCall(request).execute().use { response ->
                    val resultString = response.body!!.string()
                    //日志输出
                    Log.i(TAG, resultString)
                    // 解码JSON数据
                    val jsonObject = JSONObject(resultString)
                    // 取出Record键对应的JSON数组对象
                    val resultCode = jsonObject.getInt("ResultCode")
                    val message = if (resultCode != 0) {
                        "增加数据成功！"
                    } else "增加数据失败！"
                    Log.i(TAG, message)
                }
            } catch (e: Exception) {
                GlobalScope.launch(Dispatchers.Main) {
                    Toast.makeText(applicationContext, "服务器发生异常！", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}