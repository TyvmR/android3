package com.zhijieketang

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.util.Log
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader

// 设置实例标签
const val TAG = "ExampleCallLog"

//授权请求编码
private const val PERMISSION_REQUEST_CODE = 999

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    //声明ListView
    private var mListView: ListView? = null

    //声明游标适配器
    private var simpleCursorAdapter: SimpleCursorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 核对权限，并请求授权
        // 1、检查是否权限
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG)
            != PackageManager.PERMISSION_GRANTED
        ) {

            // 请求的权限集合
            val permissions = arrayOf(
                Manifest.permission.READ_CALL_LOG
            )

            // 2、请求授权，请求授权弹出对话框
            requestPermissions(permissions, PERMISSION_REQUEST_CODE)
            // 已经授权
        } else {
            Log.i(TAG, "  已经授权...")
            // 初始化页面
            initPage()

        }
    }


    // 初始化页面
    private fun initPage() {


        //创建SimpleCursorAdapter游标适配器对象
        simpleCursorAdapter = SimpleCursorAdapter(
            this, R.layout.listitem,
            null, arrayOf(
                CallLog.Calls.CACHED_NAME,
                CallLog.Calls.NUMBER
            ), intArrayOf(R.id.textview_name, R.id.textview_number),
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        )
        mListView = findViewById(R.id.listview)

        mListView?.adapter = simpleCursorAdapter


        mListView?.onItemLongClickListener =
            OnItemLongClickListener { parent, view, position, id ->
                val uri = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, id)
                val columns = arrayOf(
                    CallLog.Calls.NUMBER,
                    CallLog.Calls.CACHED_NAME,
                    CallLog.Calls.TYPE
                )
                val cursor = contentResolver.query(uri, columns, null, null, null)

                // 遍历游标
                if (cursor?.moveToFirst()!!) {
                    // 获得电话号码
                    val phone = cursor.getString(
                        cursor.getColumnIndex(CallLog.Calls.NUMBER)
                    )
                    // 获得联系人
                    val name = cursor.getString(
                        cursor.getColumnIndex(CallLog.Calls.CACHED_NAME)
                    )
                    // 获得【拨入、播出】电话类型
                    val type = cursor.getInt(
                        cursor.getColumnIndex(CallLog.Calls.TYPE)


                    )
                    val strype =
                        when (type) {
                            CallLog.Calls.INCOMING_TYPE -> "来电类型"
                            CallLog.Calls.OUTGOING_TYPE -> "去电类型"
                            else -> "未接来电类型"
                        }
                    val message = "联系人：${name}\n电话类型：${strype}\n电话号码：${phone}"
                    Toast.makeText(this, message, LENGTH_LONG).show()
                }
                // Lambda表达式返回值
                true
            }


        //从活动中获得LoaderManager对象
        val loaderManager = LoaderManager.getInstance(this)
        //LoaderManager初始化
        loaderManager.initLoader(0, null, this)
    }

    //创建CursorLoader时调用
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        return CursorLoader(
            this, CallLog.Calls.CONTENT_URI,
            null, null, null,
            CallLog.Calls.DEFAULT_SORT_ORDER
        )
    }

    //加载数据完成时调用
    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        //采用新的游标与老游标交换，老游标不关闭
        simpleCursorAdapter?.swapCursor(data)
    }

    //CursorLoader对象被重置时调用
    override fun onLoaderReset(loader: Loader<Cursor>) {
        //采用新的游标与老游标交换，老游标不关闭
        simpleCursorAdapter?.swapCursor(null)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {   // 判断请求Code
            // 包含授权成功权限
            if (!grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                Log.i(TAG, "  授权失败...")
            } else {
                Log.i(TAG, "  授权成功...")
                // 调用初始化函数
                initPage()
            }
        }
    }
}
