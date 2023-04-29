package com.zhijieketang

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


// 设置实例标签

const val TAG = "MyNotes"

class MainActivity : AppCompatActivity() {
    var mListView: ListView? = null

    //添加备忘录菜单项
    val ADD_MENU_ID: Int = Menu.FIRST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListView = findViewById(R.id.listview)
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
        val listData = findAll(this)
        // 绑定数据
        bindData(listData)
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

                    val dbHelper = DBHelper(this)
                    val db = dbHelper.writableDatabase
                    val seletctedData = listData[position]

                    // 取出选中的数据
                    val pk = seletctedData?.get(TABLE_FIELD_DATE)
                    // 删除数据条件
                    val whereClause = "$TABLE_FIELD_DATE = ?"
                    // 删除数据
                    db.delete(TABLE_NAME, whereClause, arrayOf(pk))
                    // 重写查询所有数据
                    val listData = findAll(this)
                    // 重写绑定数据
                    bindData(listData)
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

    // 查询所有数据函数
    private fun findAll(context: Context): List<Map<String, String>> {
        val dbHelper = DBHelper(context)
        val db = dbHelper.readableDatabase
        // 创建字段数组
        val colums = arrayOf(TABLE_FIELD_DATE, TABLE_FIELD_CONTENT)
        // 查询数据
        val cursor = db.query(
            TABLE_NAME,
            colums,
            null,
            null,
            null,
            null,
            "$TABLE_FIELD_DATE asc"
        )

        val listData = mutableListOf<Map<String, String>>()
        while (cursor.moveToNext()) {
            val row = mutableMapOf<String, String>()
            // 取出备忘录日期字段内容
            val date = cursor.getString(cursor.getColumnIndex(TABLE_FIELD_DATE))
            // 取备忘录内容字段内容
            val content = cursor.getString(cursor.getColumnIndex(TABLE_FIELD_CONTENT))

            //  将数据放到 Map对象中
            row[TABLE_FIELD_DATE] = date
            row[TABLE_FIELD_CONTENT] = content
            // 数据row放到到list集合中
            listData.add(row)
        }
        return listData
    }

    // 绑定数据
    fun bindData(listData: List<Map<String, String>>?) {
        // 创建保存控件id数组
        val to = intArrayOf(R.id.mydate, R.id.mycontent)
        // 创建保数据键数组
        val from = arrayOf(TABLE_FIELD_DATE, TABLE_FIELD_CONTENT)
        // 创建 SimpleAdapter 对象
        val simpleAdapter = SimpleAdapter(this, listData, R.layout.listitem, from, to)

        // 注册数据源观察器
        simpleAdapter.notifyDataSetChanged()
        // 设置适配器
        mListView?.adapter = simpleAdapter
    }
}