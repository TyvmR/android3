package com.zhijieketang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button


class B_Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val it = Intent(this, A_Activity::class.java)
            it.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(it)
        }
    }
}