package com.zhijieketang

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "arcsample"

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
        // 开启抗锯齿效果
        paint.isAntiAlias = false
        paint.color = Color.BLUE

        val oval1 = RectF(50f, 50f, 450f, 450f)
        canvas.drawRect(oval1, paint)

        paint.color = Color.RED
        // 绘制360度的圆
        canvas.drawArc(oval1, 90f, 360f, true, paint)

        paint.color = Color.YELLOW
        val oval2 = RectF(200.0f, 500.0f, 250f, 550f)
        // 绘制90～135度的圆弧，包含圆心
        canvas.drawArc(oval2, 90f, 135f, true, paint)

        val oval3 = RectF(300.0f, 300.0f, 600f, 600f)
        // 绘制90～135度的圆弧，不包含圆心
        canvas.drawArc(oval3, 90f, 135f, false, paint)
    }
}