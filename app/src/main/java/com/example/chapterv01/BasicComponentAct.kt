package com.example.chapterv01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BasicComponentAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_component)

        val btnListView = findViewById<Button>(R.id.basic_btn_listview)
        btnListView.setOnClickListener {
            val intent = Intent(this,BasicListViewV1::class.java)
            startActivity(intent)
        }
    }
}
