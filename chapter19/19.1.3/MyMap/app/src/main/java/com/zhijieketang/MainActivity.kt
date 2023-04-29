package com.zhijieketang

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.baidu.mapapi.SDKInitializer
import com.baidu.mapapi.map.BaiduMap

import com.baidu.mapapi.map.MapView


const val TAG = "MyMap"


class MainActivity : AppCompatActivity() {
    // 菜单项
    private val MENU_TRAFFIC: Int = Menu.FIRST      // 显示交通路况
    private val MENU_NORMAL: Int = Menu.FIRST + 1 // 普通地图模式
    private val MENU_SATELLITE: Int = Menu.FIRST + 2 // 卫星地图模式
    var mMapView: MapView? = null
    var mBaiduMap: BaiduMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 注意该方法要在setContentView方法之前实现
        SDKInitializer.initialize(applicationContext)
        setContentView(R.layout.activity_main)

        // 获取地图控件对象
        mMapView = findViewById(R.id.bmapView)
        // BaiduMap操作地图对象
        mBaiduMap = mMapView!!.map
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_TRAFFIC, 0, R.string.traffic)
        menu.add(0, MENU_NORMAL, 0, R.string.normal)
        menu.add(0, MENU_SATELLITE, 0, R.string.satellite)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            MENU_TRAFFIC -> {
                mBaiduMap!!.mapType = BaiduMap.MAP_TYPE_NORMAL
                mBaiduMap!!.isTrafficEnabled = true
            }
            MENU_NORMAL -> {
                mBaiduMap!!.mapType = BaiduMap.MAP_TYPE_NORMAL
                mBaiduMap!!.isTrafficEnabled = false
            }
            MENU_SATELLITE -> {
                mBaiduMap!!.mapType = BaiduMap.MAP_TYPE_SATELLITE
                mBaiduMap!!.isTrafficEnabled = false
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView!!.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mMapView!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMapView!!.onPause()
    }
}