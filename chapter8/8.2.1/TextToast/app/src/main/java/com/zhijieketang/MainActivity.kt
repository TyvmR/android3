package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.Button01)

        button.setOnClickListener {
            Toast.makeText(this, "你好我是Toast！", Toast.LENGTH_LONG)
                .show()
        }
    }
}