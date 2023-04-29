package com.zhijieketang

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "rectsample"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 通过自定义视图MyView设置活动内容
        setContentView(MyView(this))
    }
}

// 自定义视图类
class MyView(context: Context?) : View(context) {
    override fun onDraw(canvas: Canvas) {

        //创建画笔
        val paint = Paint()
        //设置画笔颜色
        paint.color = Color.RED

        // 创建基于整数的矩形
        val r1 = Rect(50, 50, 300, 300)
        //绘制矩形
        canvas.drawRect(r1, paint)

        paint.color = Color.BLUE
        // 创建基于浮点数的矩形
        val r2 = RectF(100.0f, 360.0f, 300.0f, 600.0f)
        canvas.drawRect(r2, paint)
    }
}