/*
* Created by 画画的程序员
* 智捷课堂微信公共号：【zhijieketang】 或 【画画的程序员】
* 邮箱：eorient@sina.com
*
*/
//Kotlin代码文件：HelloProj/src/main/kotlin/com/zhijieketang/BookTableModel.kt
package com.zhijieketang

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import java.io.FileReader
import javax.swing.table.AbstractTableModel

//图书实体类
data class Book(
    // 图书编号
    val bookid: String,
    // 图书名称
    val bookname: String,
    // 图书作者
    val author: String,
    // 出版社
    val publisher: String,
    // 出版日期
    val pubtime: String,
    // 库存数量
    val inventory: Int
)


class BookTableModel() : AbstractTableModel() {
    private val bookList: List<Book>
        get() {
            // 数据文件
            val dbFile = "./db/Books.json"
            //  读取文件
            (FileReader(dbFile)).use { fileReader ->
                val jsonString = fileReader.readText()
                val gson = Gson()
                val list = gson.fromJson<List<Book>>(jsonString)
                return list
            }
        }

    // 列名数组
    private val columnNames = arrayOf("书籍编号", "书籍名称", "作者", "出版社", "出版日期", "库存数量")

    // 获得行数
    override fun getRowCount(): Int = bookList.size

    // 获得列数
    override fun getColumnCount(): Int = columnNames.size

    // 获得row行col列的数据
    override fun getValueAt(row: Int, col: Int): Any? {
        val (bookid, bookname, author, publisher, pubtime, inventory) = bookList[row]
        return when (col) {
            0 -> bookid
            1 -> bookname
            2 -> author
            3 -> publisher
            4 -> pubtime
            5 -> inventory
            else -> null
        }
    }

    // 获得某列的名字
    override fun getColumnName(col: Int): String = columnNames[col]
}
