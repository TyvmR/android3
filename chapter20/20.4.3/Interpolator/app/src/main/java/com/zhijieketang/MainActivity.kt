package com.zhijieketang


import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "Interpolator"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(
                this,
                R.anim.translate_anim
            )
            val view = findViewById<View>(R.id.imageView)
            //在视图view上设置并开始动画
            view.startAnimation(anim)
        }
    }
}

