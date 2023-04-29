package com.zhijieketang

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

//文件名
const val DATABASE_NAME = "MyNote.sqlite3"

//健康表名
const val TABLE_NAME = "Note"

//应用的数据版本
const val DATABASE_VERSION = 10

//备忘录日期
const val TABLE_FIELD_DATE = "_id"

//备忘录内容
const val TABLE_FIELD_CONTENT = "content"

class DBHelper(context: Context?) :
    SQLiteOpenHelper(
        context, DATABASE_NAME, null, DATABASE_VERSION
    ) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """CREATE TABLE IF NOT EXISTS  Note (
                _id Text PRIMARY KEY, 
                content TEXT)"""
        Log.i(TAG, sql)

        try {
            db?.execSQL(sql)

            // TODO 插入两条测试数据
            db?.execSQL(
                "insert into Note (_id, content) values('2021-01-01 18:01:09','Welcome to MyNote.')"
            )
            db?.execSQL(
                "insert into Note (_id, content) values('2022-08-08 8:01:16','欢迎使用MyNote。')"
            )
        } catch (e: Exception) {
            Log.e(TAG, "数据库初始化发生异常！")

            e.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 删除表
        db?.execSQL("DROP TABLE IF EXISTS Note ")
        onCreate(db)
    }
}
