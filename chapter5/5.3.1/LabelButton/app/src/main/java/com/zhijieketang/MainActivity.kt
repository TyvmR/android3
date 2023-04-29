package com.zhijieketang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //通过id获得OK按钮对象
        val btnOK = this.findViewById<Button>(R.id.button)
        //注册事件监听器
        btnOK.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val textView = this.findViewById<TextView>(R.id.textView)
        textView.text = "HelloWorld"
    }
}