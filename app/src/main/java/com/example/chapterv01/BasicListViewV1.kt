package com.example.chapterv01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

 val mStrings = arrayOf("上海","天津","澳门","北京")

class BasicListViewV1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_list_view_v1)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings)
        val view = findViewById<ListView>(R.id.ListView_01)
        view.adapter = arrayAdapter

        view.onItemClickListener = object: AdapterView.OnItemClickListener {

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                println(mStrings[position])
            }

        }
    }
}
