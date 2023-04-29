package com.zhijieketang

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


var DATA = arrayOf(
    "北京市", "天津市", "上海", "重庆", "哈尔滨",
    "石家庄", "秦皇岛", "济南", "青岛", "南京", "三亚", "昆明",
    "成都", "长沙", "武汉", "九江", "香港", "澳门"
)

var icons = intArrayOf(
    R.mipmap.beijing, R.mipmap.tianjing, R.mipmap.shanghai,
    R.mipmap.chongqing, R.mipmap.haerbing, R.mipmap.shijiazhuang,
    R.mipmap.qinhuangdao, R.mipmap.jinan, R.mipmap.qingdao,
    R.mipmap.nanjing, R.mipmap.sanya, R.mipmap.kunming,
    R.mipmap.chengdu, R.mipmap.changsha, R.mipmap.wuhan,
    R.mipmap.jiujiang, R.mipmap.xianggang, R.mipmap.aomen
)


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = EfficientAdapter(
            this,
            R.layout.listview_item, DATA, icons
        )

        val listview = findViewById<ListView>(R.id.ListView01)
        listview.adapter = adapter

        listview.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                println("选择了选项:" + DATA[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("未选中")
            }

        }
    }
}