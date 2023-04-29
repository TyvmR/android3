package com.zhijieketang

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader

// 设置实例标签
const val TAG = "GetContacts"

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
                Manifest.permission.READ_CONTACTS
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
    fun initPage() {

        //创建SimpleCursorAdapter游标适配器对象
        simpleCursorAdapter = SimpleCursorAdapter(
            this, R.layout.listitem,
            null, arrayOf(
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME
            ), intArrayOf(R.id.textview_no, R.id.textview_name),
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        )
        mListView = findViewById(R.id.listview)

        mListView?.adapter = simpleCursorAdapter
        mListView?.onItemLongClickListener =
            OnItemLongClickListener { parent, view, position, id ->
                val uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id)
                val columns = arrayOf(
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME
                )
                val cursor = contentResolver.query(uri, columns, null, null, null)

                // 遍历游标
                if (cursor?.moveToFirst()!!) {
                    val contactId = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts._ID)
                    )
                    val contactName = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                    )
                    Log.i(TAG, "$contactId | $contactName")
                    // 查看电话号码
                    val phones = findPhones(contactId)
                    if (phones.isEmpty()) {
                        makeText(this, "$contactName 没有电话号码。", LENGTH_LONG).show()
                    } else {
                        makeText(this, "$contactName ${phones}", LENGTH_LONG).show()
                    }
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
        return CursorLoader(this, ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
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

    /**
     * 选择查看【电话号码】
     *
     * @param contactId 联系人id
     */
    private fun findPhones(contactId: String): List<String> {
        var phones = mutableListOf<String>()
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            "${ContactsContract.CommonDataKinds.Phone.CONTACT_ID} = $contactId",
            null, null
        )
        while (cursor!!.moveToNext()) {
            val phoneNumber =
                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            phones.add(phoneNumber)
            Log.i(TAG, "电话号码 : $phoneNumber")
        }
        cursor.close()
        return phones
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