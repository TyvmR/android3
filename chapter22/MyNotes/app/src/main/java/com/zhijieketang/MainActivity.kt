package com.zhijieketang

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.net.URL

// 服务器端口
const val SER_HOST_PORT = 8080

// 服务器端口
const val SER_HOST_IP = "192.168.0.189"

// 设置实例标签
const val TAG = "MyNotes"

const val KEY_DATE = "CDate"
const val KEY_ID = "ID"
const val KEY_CONTEN = "Content"

class MainActivity : AppCompatActivity() {
    private var mListView: ListView? = null
    private var mSwiperefresh: SwipeRefreshLayout? = null

    //添加备忘录菜单项
    val ADD_MENU_ID: Int = Menu.FIRST

    // 创建List对象用来保存返回的数据
    private val mListData = mutableListOf<Map<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSwiperefresh = findViewById(R.id.swiperefresh)
        mListView = findViewById(R.id.listview)

        mSwiperefresh!!.setOnRefreshListener {
            // 查询并绑定数据
            findAll()
        }

        mListView?.setOnItemLongClickListener { parent, view, position, id ->

            val dialog = AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)          //设置对话框图标
                .setTitle(
                    R.string.info
                )//设置对话框标题
                .setMessage(
                    R.string.message1
                ) //设置对话框显示文本信息
                .setPositiveButton(
                    R.string.ok
                ) { dialog, which ->
                    // 删除数据
                    removeData(position)
                }
                .setNegativeButton(
                    R.string.cancel
                ) { dialog, which ->
                }
                .create()
            dialog.show()

            true
        }
    }


    // 绑定数据函数
    private fun bindData() {
        // 创建保存控件id数组
        val to = intArrayOf(R.id.mydate, R.id.mycontent)
        // 创建保数据键数组
        val from = arrayOf(KEY_DATE, KEY_CONTEN)
        // 创建 SimpleAdapter 对象
        val simpleAdapter = SimpleAdapter(this, mListData, R.layout.listitem, from, to)

        val uiDispatcher = Dispatchers.Main
        GlobalScope.launch(uiDispatcher) {

            simpleAdapter.notifyDataSetChanged()
            // 设置适配器
            mListView?.adapter = simpleAdapter

            makeText(applicationContext, "加载数据完成！！", LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, ADD_MENU_ID, 1, R.string.add).setIcon(
            android.R.drawable.ic_menu_add
        ).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            ADD_MENU_ID -> {
                val it = Intent(this, ModAddActivity::class.java)
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        // 查询所有数据
        findAll()
    }

    // 查询所有数据函数
    private fun findAll() {
        val urlFormat = "http://%s:%s/NoteWebService/note.do?action=query"
        val strUrl = String.format(urlFormat, SER_HOST_IP, SER_HOST_PORT)
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



                    mSwiperefresh!!.isRefreshing = false

                    //日志输出
                    Log.i(TAG, resultString)
                    // 解码JSON数据
                    val jsonObject = JSONObject(resultString)
                    // 取出Record键对应的JSON数组对象
                    val jsonArray: JSONArray = jsonObject.getJSONArray("Record")

                    // 先清空所有数据
                    mListData.clear()
                    for (i in 0 until jsonArray.length()) {
                        val row = jsonArray[i] as JSONObject
                        val CDate = row.getString(KEY_DATE)
                        val Content = row.getString(KEY_CONTEN)
                        val ID = row.getString(KEY_ID)

                        val note = mutableMapOf<String, String>()
                        note[KEY_DATE] = CDate
                        note[KEY_CONTEN] = Content
                        note[KEY_ID] = ID
                        mListData.add(note)
                    }
                }
                // 绑定数据
                bindData()
            } catch (e: Exception) {
                GlobalScope.launch(Dispatchers.Main) {
                    makeText(applicationContext, "服务器发生异常！", LENGTH_LONG).show()
                    mSwiperefresh!!.isRefreshing = false
                }
            }
        }
    }

    // 删除数据函数
    private fun removeData(position: Int) {
        // 选择数据行，数据类型是Map
        val row = mListData[position]
        // 取出ID
        val ID = row[KEY_ID]!!
        val urlFormat = "http://%s:%s/NoteWebService/note.do?action=remove&ID=%s"
        val strUrl = String.format(urlFormat, SER_HOST_IP, SER_HOST_PORT, ID)
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
                        "ID：${ID}数据删除成功！"
                    } else "ID：${ID}数据删除失败！"

                    Log.i(TAG, message)
                    GlobalScope.launch(Dispatchers.Main) {
                        makeText(applicationContext, message, LENGTH_LONG).show()
                    }
                }
            } catch (e: Exception) {
                GlobalScope.launch(Dispatchers.Main) {
                    makeText(applicationContext, "服务器发生异常！", LENGTH_LONG).show()
                }
            }
            // 重新查询所有数据
            findAll()
        }

    }
}