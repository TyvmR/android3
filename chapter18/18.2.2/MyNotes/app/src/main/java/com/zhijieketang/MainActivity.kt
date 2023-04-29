package com.zhijieketang

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


// 设置实例标签
const val TAG = "MyNotes"

const val KEY_DATE = "CDate"
const val KEY_CONTEN = "Content"

//Web服务网址
const val URL_STR = "http://192.168.0.189:8080/NoteWebService/note.do?action=query"

class MainActivity : AppCompatActivity() {
    var mListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListView = findViewById(R.id.listview)
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

            // 解码JSON数据
            val jsonObject = JSONObject(resultString)
            val jsonArray: JSONArray = jsonObject.getJSONArray("Record")
            val listData = mutableListOf<Map<String, String>>()
            for (i in 0 until jsonArray.length()) {

                val row = jsonArray[i] as JSONObject
                val CDate = row.getString("CDate")
                val Content = row.getString("Content")
                val ID = row.getString("ID")

                val note = mutableMapOf<String, String>()
                note[KEY_DATE] = CDate
                note[KEY_CONTEN] = Content
                listData.add(note)

            }

            val uiDispatcher = Dispatchers.Main
            // 启动协程
            GlobalScope.launch(uiDispatcher) { // 主线程调度器

                // 绑定数据
                bindData(listData)
            }
        }
    }

    // 绑定数据
    fun bindData(listData: List<Map<String, String>>?) {
        // 创建保存控件id数组
        val to = intArrayOf(R.id.mydate, R.id.mycontent)
        // 创建保数据键数组
        val from = arrayOf(KEY_DATE, KEY_CONTEN)
        // 创建 SimpleAdapter 对象
        val simpleAdapter = SimpleAdapter(this, listData, R.layout.listitem, from, to)
        // 设置适配器
        mListView?.adapter = simpleAdapter
    }
}