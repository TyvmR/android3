package com.example.chapterv01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button


const val TAG = "FileSample"

const val DATABASE_NAME  = "Health.csv"

const val TABLE_NAME = "Health"

const val TABLE_FIELD_DATE = "_id"

const val TABLE_FIELD_INPUT = "input"

const val TABLE_FIELD_OUTPUT = "output"

const val TABLE_FIELD_WEIGHT = "weight"

const val TABLE_FIELD_AMOUNTEXERCISE = "amountExercise"

class CsvInputInfoAct : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csv_input_info)
        val readBtn = findViewById<Button>(R.id.csv_read_button)
        val writeBtn = findViewById<Button>(R.id.csv_write_button)
        readBtn.setOnClickListener(this)
        writeBtn.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id) {
            //写入数据
            R.id.csv_write_button -> {
                create()
            }
            //读取数据
            R.id.csv_read_button -> {
                findAll()
            }
        }
    }




    fun create() {
        val rows = StringBuffer()
        rows.apply {
            append("1237490238098,1500kcal,3000kcal,90kg,5km")
            append("\n")
            append("1237490238098,1500kcal,3000kcal,90kg,5km")
            append("\n")
        }
        this.openFileOutput(DATABASE_NAME, Context.MODE_PRIVATE).use {
            val bufferedWriter = it.bufferedWriter()
            bufferedWriter.use {
                bufferedWriter.write(rows.toString())
            }
        }
    }


    fun findAll(): List<Map<String,String>>? {

        val list  = mutableListOf<Map<String,String>>()

        openFileInput(DATABASE_NAME).use {
            val bufferedReader = it.bufferedReader()

            bufferedReader.forEachLine {
                val fields = it.split(",")
                val row = mutableMapOf<String, String>()
                row[TABLE_FIELD_DATE] = fields[0]
                row[TABLE_FIELD_INPUT] = fields[1]
                row[TABLE_FIELD_OUTPUT] = fields[2]
                row[TABLE_FIELD_WEIGHT] = fields[3]
                row[TABLE_FIELD_AMOUNTEXERCISE] = fields[4]
                list.add(row)
            }
        }
        Log.i("mainact",list.toString())
        return list
    }







}
