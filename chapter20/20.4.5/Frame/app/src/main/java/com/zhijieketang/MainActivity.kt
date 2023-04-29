package com.zhijieketang

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "Frame"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val imgView: ImageView = findViewById(R.id.imageView)
            imgView.setBackgroundResource(R.drawable.frame_animation)

            val frameAnimation = imgView.background as AnimationDrawable
            if (frameAnimation.isRunning) {
                frameAnimation.stop()
            } else {
                frameAnimation.stop()
                frameAnimation.start()
            }
        }
    }
}


