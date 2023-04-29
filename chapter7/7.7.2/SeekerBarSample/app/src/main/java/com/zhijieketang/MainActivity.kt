package com.zhijieketang

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var mProgressText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mProgressText = findViewById(R.id.progress)

        val seekBar1 = findViewById<SeekBar>(R.id.seekBar1)
        seekBar1.setOnSeekBarChangeListener(this)

        val seekBar2 = findViewById<SeekBar>(R.id.seekBar2)
        seekBar2.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        mProgressText?.text = "当前进度:${progress}%"
        println("当前进度:${progress}%")
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        println("开始拖动。")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        println("停止拖动。")
    }
}