package com.zhijieketang

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

// 定义步长常量
const val STEP = 3


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressHorizontal01 = findViewById<ProgressBar>(R.id.progress_horizontal01)
        //获取被包含按钮栏button_bar1
        val buttonBar1 = findViewById<LinearLayout>(R.id.button_bar1)
        //从按钮栏中取出+按钮
        val bar1IncreaseButton = buttonBar1.findViewById<Button>(R.id.increase)
        //+按钮事件处理
        bar1IncreaseButton.setOnClickListener { progressHorizontal01.incrementProgressBy(STEP) }
        //从按钮栏中取出-按钮
        val bar1DecreaseButton = buttonBar1.findViewById<Button>(R.id.decrease)
        //-按钮事件处理
        bar1DecreaseButton.setOnClickListener { progressHorizontal01.incrementProgressBy(-STEP) }

        val progressHorizontal02 = findViewById<ProgressBar>(R.id.progress_horizontal02)
        //获取被包含按钮栏button_bar2
        val buttonBar2 = findViewById<LinearLayout>(R.id.button_bar2)
        //从按钮栏中取出+按钮
        val bar2IncreaseButton = buttonBar2.findViewById<Button>(R.id.increase)
        //从按钮栏中取出+按钮
        bar2IncreaseButton.setOnClickListener { progressHorizontal02.incrementProgressBy(STEP) }
        //从按钮栏中取出-按钮
        val bar2DecreaseButton = buttonBar2.findViewById<Button>(R.id.decrease)
        //-按钮事件处理
        bar2DecreaseButton.setOnClickListener { progressHorizontal02.incrementProgressBy(-STEP) }


        //获取被包含按钮栏button_bar3
        val buttonBar3 = findViewById<LinearLayout>(R.id.button_bar3)

        //从按钮栏中取出+按钮
        val bar3IncreaseButton = buttonBar3.findViewById<Button>(R.id.increase)
        //+按钮事件处理
        bar3IncreaseButton.setOnClickListener {
            progressHorizontal02.incrementSecondaryProgressBy(STEP)
        }

        //从按钮栏中取出-按钮
        val bar3DecreaseButton = buttonBar3.findViewById<Button>(R.id.decrease)
        //-按钮事件处理
        bar3DecreaseButton.setOnClickListener { progressHorizontal02.incrementSecondaryProgressBy(-STEP) }
    }
}