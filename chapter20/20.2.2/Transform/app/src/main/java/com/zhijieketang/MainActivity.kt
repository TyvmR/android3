package com.zhijieketang

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "BitmapSample"

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
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.cat)
        val matrix = Matrix()
        matrix.setScale(0.8f, 0.8f, 40f, 40f)
        matrix.postRotate(40f, 100f, 200f)
//        matrix.setRotate(40f, 100f, 200f)
        matrix.postTranslate(50f, 100f)
        //创建画笔对象
        val paint = Paint()
        //绘制位图
        canvas.drawBitmap(bitmap, matrix, paint)

    }
}