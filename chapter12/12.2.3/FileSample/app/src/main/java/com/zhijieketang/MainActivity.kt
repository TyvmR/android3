package com.zhijieketang

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import java.io.IOException

// 设置实例标签

const val TAG = "FileSample"

//文件名
const val DATABASE_NAME = "Health.csv"

//健康表名
const val TABLE_NAME = "Health"

//日期
const val TABLE_FIELD_DATE = "_id"

//摄入热量
const val TABLE_FIELD_INPUT = "input"

//消耗热量
const val TABLE_FIELD_OUTPUT = "output"

//体重
const val TABLE_FIELD_WEIGHT = "weight"

//运动情况
const val TABLE_FIELD_AMOUNTEXERCISE = "amountExercise"


class MainActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRead = findViewById<Button>(R.id.button_read)
        btnRead.setOnClickListener(this)


        var btnWrite = findViewById<Button>(R.id.button_write)
        btnWrite.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            // 写入数据
            R.id.button_write -> {
                create()
            }
            // 读取数据
            R.id.button_read -> {
                // 返回数据
                val list = findAll()

                // 判断返回的数据为空
                if (list.isEmpty()) {
                    makeText(this, "数据为空！请先写入数据，再读取数据。", LENGTH_LONG).show()
                    Log.d(TAG, "数据为空")
                }
                // 遍历返回的数据
                list.forEachIndexed { index, rows ->
                    Log.i(TAG, "===========第${index + 1}条数据=======================")
                    Log.i(TAG, "日期：${rows[TABLE_FIELD_DATE]}")
                    Log.i(TAG, "摄入热量：${rows[TABLE_FIELD_INPUT]}")
                    Log.i(TAG, "消耗热量：${rows[TABLE_FIELD_OUTPUT]}")
                    Log.i(TAG, "体重：${rows[TABLE_FIELD_WEIGHT]}")
                    Log.i(TAG, "运动情况：${rows[TABLE_FIELD_AMOUNTEXERCISE]}")
                }
            }
        }
    }

    // 读取所有数据
    private fun findAll(): List<Map<String, String>> {
        Log.i(TAG, "读取所有数据")
        // 创建可变集合对象
        val list = mutableListOf<Map<String, String>>()


        try {
            // 打开文件输入流
            openFileInput(DATABASE_NAME).use { inputStream ->
                // 从输入流构建字符缓冲区输入流
                val br = inputStream.bufferedReader()
                // 遍历输入流中的每一行数据，对每一行数据进行处理
                br.forEachLine { line ->
                    // 通过逗号分割字符串数据
                    val fields = line.split(",")
                    // 创建保存一行数据的可变Map集合对象row
                    val row = mutableMapOf<String, String>()
                    row[TABLE_FIELD_DATE] = fields[0]
                    row[TABLE_FIELD_INPUT] = fields[1]
                    row[TABLE_FIELD_OUTPUT] = fields[2]
                    row[TABLE_FIELD_WEIGHT] = fields[3]
                    row[TABLE_FIELD_AMOUNTEXERCISE] = fields[4]
                    // 把一行数据对象row放到list集合中
                    list.add(row)

                }
            }
        } catch (e: IOException) {
            Log.d(TAG, "读取数据失败！")
        }

        return list
    }


    //    写入数据函数
    private fun create() {
        Log.i(TAG, "写入数据")
        val rows = StringBuffer()
        rows.append("1289645040579,1500大卡,3000大卡,90kg,5公里").append("\n")
        rows.append("1289732522328,2500大卡,4000大卡,95kg,5公里").append("\n")


        try {
            // 打开文件输出流
            this.openFileOutput(DATABASE_NAME, MODE_PRIVATE).use { outputStream ->

                // 从输出流构建字符缓冲区输出流
                val bw = outputStream.bufferedWriter()
                bw.use {
                    bw.write(rows.toString())
                }
            }

        } catch (e: IOException) {
            Log.d(TAG, "写入数据失败！")
        }
    }
}