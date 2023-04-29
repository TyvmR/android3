package com.zhijieketang

import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    var mCheckbox1: CheckBox? = null
    var mCheckbox2: CheckBox? = null
    var mCheckbox3: CheckBox? = null
    var mCheckbox4: CheckBox? = null
    var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.TextView01)
        // 获得CheckBox1对象
        mCheckbox1 = findViewById(R.id.CheckBox01)
        //注册CheckBox1监听器
        mCheckbox1?.setOnCheckedChangeListener(this)
        // 获得CheckBox02对象
        mCheckbox2 = findViewById(R.id.CheckBox02)
        //注册CheckBox02监听器
        mCheckbox2?.setOnCheckedChangeListener(this)
        // 获得CheckBox3对象
        mCheckbox3 = findViewById(R.id.CheckBox03)
        //注册CheckBox3监听器
        mCheckbox3?.setOnCheckedChangeListener(this)
        // 获得CheckBox4对象
        mCheckbox4 = findViewById(R.id.CheckBox04)
        //注册CheckBox4监听器
        mCheckbox4?.setOnCheckedChangeListener(this)

    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        val ckb = buttonView as CheckBox

        mTextView!!.text = "[单击了${ckb.text}，状态是：${isChecked}]"
    }
}