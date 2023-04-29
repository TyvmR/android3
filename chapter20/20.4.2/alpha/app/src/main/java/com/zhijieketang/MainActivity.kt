package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "alpha"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alphaButton = findViewById<Button>(R.id.alpha_button)
        alphaButton.setOnClickListener {

            ///1. 编程实现

            val anim: Animation = AlphaAnimation(1.0f, 0.0f)
            anim.duration = 5000

            ///2.XML实现

            //从动画XML文件中加载动画对象
//            val anim: Animation = AnimationUtils.loadAnimation(
//                this,
//                R.anim.alpha_anim
//            )
            val view: View = findViewById(R.id.imageView)
            //在视图view上设置并开始动画
            view.startAnimation(anim)
        }

        val translateButton = findViewById<Button>(R.id.translate_button)
        translateButton.setOnClickListener {
            //从动画XML文件中加载动画对象
            val anim: Animation = AnimationUtils.loadAnimation(
                this,
                R.anim.translate_anim
            )
            val view: View = findViewById(R.id.imageView)
            //在视图view上设置并开始动画
            view.startAnimation(anim)
        }

        val scaleButton = findViewById<Button>(R.id.scale_button)
        scaleButton.setOnClickListener {
            //从动画XML文件中加载动画对象
            val anim: Animation = AnimationUtils.loadAnimation(
                this,
                R.anim.scale_anim
            )
            val view: View = findViewById(R.id.imageView)
            //在视图view上设置并开始动画
            view.startAnimation(anim)
        }

        val rotateButton = findViewById<Button>(R.id.rotate_button)
        rotateButton.setOnClickListener {
            //从动画XML文件中加载动画对象
            val anim: Animation = AnimationUtils.loadAnimation(
                this,
                R.anim.rotate_anim
            )
            val view: View = findViewById(R.id.imageView)
            //在视图view上设置并开始动画
            view.startAnimation(anim)
        }
    }
}
