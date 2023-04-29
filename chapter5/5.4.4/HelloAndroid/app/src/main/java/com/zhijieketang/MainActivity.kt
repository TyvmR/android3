package com.zhijieketang

import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// 透明度变化步长
const val STEP = 20 // 编译期常量

class MainActivity : AppCompatActivity() {


    // 声明成员变量
    private var mAlphavalueText: TextView? = null
    private var mImage: ImageView? = null

    // 保存图片的透明度
    private var mAlphavalue = 100 // 透明度初始值100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mImage = findViewById<ImageView>(R.id.image)
        mAlphavalueText = findViewById<TextView>(R.id.alphavalue)
        mImage?.imageAlpha = mAlphavalue   //设置图片透明度
        mAlphavalueText?.text = "Alpha = ${mAlphavalue * 100 / 255}%"
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when (event?.action) {
            KeyEvent.ACTION_DOWN ->
                println("键盘按下")
            KeyEvent.ACTION_UP ->
                println("键盘抬起")
        }

        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> //放大声音键
                mAlphavalue += STEP
            KeyEvent.KEYCODE_VOLUME_DOWN -> //缩小声音键
                mAlphavalue -= STEP
        }

        if (mAlphavalue >= 255) {
            mAlphavalue = 255
        }
        if (mAlphavalue <= 0) {
            mAlphavalue = 0
        }

        mImage?.imageAlpha = mAlphavalue
        mAlphavalueText?.text = "Alpha = ${mAlphavalue * 100 / 255}%"
        return super.onKeyDown(keyCode, event)
    }
}