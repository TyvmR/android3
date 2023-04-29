package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edittext = findViewById<EditText>(R.id.username)

        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener {
            edittext.setText("你好我是EditText")
            println(edittext.text)
        }

    }
}
