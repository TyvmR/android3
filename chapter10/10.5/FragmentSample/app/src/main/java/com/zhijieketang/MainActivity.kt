package com.zhijieketang

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity(), EventsMasterFragment.OnTitleSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("设备是平板电脑: ${isTablet(this)} ")

        if (isTablet(this)) {
            // 如果是平板设备，则设置为横屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            // 如果是手机设备，则设置为竖屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

            // 创建碎片实例
            val firstFragment = EventsMasterFragment()
            // 将意图的扩展数据（Extras）,放到碎片参数中
            firstFragment.arguments = intent.extras

            val fragmentManager: FragmentManager = supportFragmentManager

            // 获得FragmentTransaction对象
            val transaction = fragmentManager.beginTransaction()

            // 添加firstFragment碎片到fragment_container容器
            transaction.add(R.id.fragment_container, firstFragment)
            // 提交碎片
            transaction.commit()
        }
    }

    //用户从Master碎片选中列表项时调用
    override fun onEventsSelected(position: Int) {

        val fragmentManager = supportFragmentManager

        // 使用FragmentManager通过id获得详细碎片
        val detailFragment = fragmentManager.findFragmentById(R.id.fragment_detail)

        if (detailFragment != null) { // 1.如果Detail碎片可用，则说明是两栏布局情况
            // 调用该方法更新Detail碎片内容
            (detailFragment as EventsDetailFragment).updateDetailView(position)
        } else {
            // 2.如果Detail碎片不可用，则说明是单栏布局情况
            // 创建新的Detail碎片
            val newFragment = EventsDetailFragment()
            val args = Bundle()
            args.putInt(EVENTS_POSITION, position)
            newFragment.arguments = args

            val transaction = fragmentManager.beginTransaction()

            // 替换fragment_container中的原有碎片
            transaction.replace(R.id.fragment_container, newFragment)
            // 添加碎片事务到返回栈，以便于用户单击Back能够导航回到上一个碎片
            transaction.addToBackStack(null)

            // 提交碎片事务
            transaction.commit()
        }


    }

    // 判断是否为平板设备
    private fun isTablet(context: Context): Boolean {
        return this.resources.configuration.screenLayout and SCREENLAYOUT_SIZE_MASK >= SCREENLAYOUT_SIZE_LARGE
    }
}