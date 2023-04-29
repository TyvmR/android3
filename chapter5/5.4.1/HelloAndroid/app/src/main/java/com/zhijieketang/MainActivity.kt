package com.zhijieketang

import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // 声明成员变量
    private var mAction: TextView? = null
    private var mPostion: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAction = findViewById<TextView>(R.id.action)
        mPostion = findViewById<TextView>(R.id.postion)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // 获得事件动作
        val action = event?.action

        when (action) {
            MotionEvent.ACTION_UP ->
                mAction?.text = "手指抬起"
            MotionEvent.ACTION_DOWN ->
                mAction?.text = "手指按下"
            else -> mAction?.text = "手指移动"
        }
        // 获得当前位置坐标
        val X = event?.getX()
        val Y = event?.getY()
        mPostion?.text = "位置 = ( $X  ,  $Y  )"
        return super.onTouchEvent(event)
    }
}