package com.zhijieketang

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "pointline"

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

        val x = 0.0f
        val y = 100.0f
        val height = 100
        //创建画笔对象
        val paint = Paint()
        //设置画笔颜色
        paint.color = Color.RED
        //设置笔的粗细
        paint.strokeWidth = 5.0f
        // 在画布上画线
        canvas.drawLine(x, y, x + width - 1, y, paint)
        canvas.drawLine(x, y + height - 1, x + width, y
                + height - 1, paint)

        //重新设置画笔
        paint.color = Color.BLACK
        paint.strokeWidth = 10.0f
        // 准备100个数据
        val pts = FloatArray(100)
        var i = 0
        while (i < 100) {
            pts[i] = (i * 5).toFloat()
            pts[i + 1] = (i * 15).toFloat()
            i += 2
        }
        // 在画布上画点
        canvas.drawPoints(pts, 20, 10, paint)
    }
}