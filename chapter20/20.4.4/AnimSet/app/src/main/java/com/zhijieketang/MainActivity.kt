package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "AnimSet"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val anim: Animation = AnimationUtils.loadAnimation(
                this,
                R.anim.animset_anim
            )
            val view = findViewById<View>(R.id.imageView)
            //在视图view上设置并开始动画
            view.startAnimation(anim)
        }
    }
}


