package com.zhijieketang

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val btn1: Button? = null
    private val btn2: Button? = null
    private val btn3: Button? = null
    private val btn4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)

        btn1?.setOnClickListener {
            // 打开Web浏览器
            val uri = Uri.parse("http://www.sina.com/")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }

        btn2?.setOnClickListener {
            // 打开地图
            val uri: Uri = Uri.parse("geo:39.904667,116.408198")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }

        btn3?.setOnClickListener {
            // 拨打电话
            val uri = Uri.parse("tel:100861")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }
        btn4?.setOnClickListener {
            // 发送Email
            val it = Intent(Intent.ACTION_SEND)
            //发送内容
            it.putExtra(Intent.EXTRA_TEXT, "The email body text")
            //发送主题
            it.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            //设置数据类型
            it.type = "text/plain"
            startActivity(it)
        }
    }
}