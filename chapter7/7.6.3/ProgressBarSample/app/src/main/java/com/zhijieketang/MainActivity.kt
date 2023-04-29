package com.zhijieketang

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar1 = findViewById<ProgressBar>(R.id.progressBar1)
        val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        val button = findViewById<ToggleButton>(R.id.toggleButton)

        //按钮事件处理
        button.setOnClickListener {
            if (button.isChecked) {
                progressBar1.visibility = ProgressBar.GONE
                progressBar2.visibility = ProgressBar.INVISIBLE
            } else {
                progressBar1.visibility = ProgressBar.VISIBLE
                progressBar2.visibility = ProgressBar.VISIBLE
            }
        }
    }
}