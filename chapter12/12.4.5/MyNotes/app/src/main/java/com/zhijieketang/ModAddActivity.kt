package com.zhijieketang

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.util.*


class ModAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_mod)

        val btnOk = findViewById<Button>(R.id.btnok)
        val txtInput = findViewById<EditText>(R.id.incontent)
        val btnCancel = findViewById<Button>(R.id.btncancel)

        // 单击确定按钮插入数据
        btnOk.setOnClickListener {


            val dbHelper = DBHelper(this)
            val db = dbHelper.writableDatabase

            val date = Date()  // 获得当前日期时间
            // 准备插入数据
            val values = ContentValues()

            val format = DateFormat.getDateTimeInstance(
                DateFormat.DEFAULT,
                DateFormat.SHORT,
                Locale.getDefault()
            )
            // 将备忘录日期放入ContentValues对象
            values.put(TABLE_FIELD_DATE, format.format(date))
            // 将备忘录信息放入ContentValues对象
            values.put(TABLE_FIELD_CONTENT, txtInput.text.toString())
            // 插入数据
            db.insert(TABLE_NAME, null, values)
            // 单击取消按钮返回列表界面
            finish()
        }
        // 单击取消按钮返回列表界面
        btnCancel.setOnClickListener {
            this.finish()
        }
    }
}