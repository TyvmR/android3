package com.zhijieketang

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { text.text = "单击了Button!" }
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        imageButton.setOnClickListener { text.text = "单击了ImageButton!" }

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        toggleButton.setOnClickListener { view ->
            val toggleButton = view as ToggleButton
            text.text = "单击了ToggleButton,状态：${toggleButton.isChecked}"

        }
    }
}