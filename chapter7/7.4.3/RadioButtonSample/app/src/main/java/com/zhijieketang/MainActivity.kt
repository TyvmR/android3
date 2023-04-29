package com.zhijieketang

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById<TextView>(R.id.TextView01)
        val mRadioGroup1 = findViewById<RadioGroup>(R.id.RadioGroup1)
        //注册RadioGroup1监听器
        mRadioGroup1.setOnCheckedChangeListener(this)
        val mRadioGroup2 = findViewById<RadioGroup>(R.id.RadioGroup2)
        //注册RadioGroup2监听器
        mRadioGroup2.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(rdp: RadioGroup, checkedId: Int) {
        when (rdp.id) {
            R.id.RadioGroup1 -> {
                val rb1 = this.findViewById<RadioButton>(checkedId)
                mTextView?.text = "选择性别：${rb1.text}"
            }
            R.id.RadioGroup2 -> {
                val rb2 = this.findViewById<RadioButton>(checkedId)
                mTextView?.text = "选择语言：${rb2.text}"
            }
        }
    }
}
