package com.zhijieketang

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.baidu.mapapi.SDKInitializer
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng


private const val TAG = "MyLocation"

//授权请求编码
private const val PERMISSION_REQUEST_CODE = 999

class MainActivity : AppCompatActivity(), LocationListener {
    private var mLatitude: TextView? = null
    private var mLongitude: TextView? = null
    private var mAltitude: TextView? = null

    //定位服务管理类
    private var mLocationManager: LocationManager? = null
    var mMapView: MapView? = null
    var mBaiduMap: BaiduMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(applicationContext)
        setContentView(R.layout.activity_main)

        // 获取地图控件对象
        mMapView = findViewById(R.id.bmapView)
        // BaiduMap操作地图对象
        mBaiduMap = mMapView!!.map
        //设定中心点坐标
        val cenpt = LatLng(39.84064836308104, 116.36897553417967)
        //定义地图状态
        val mapStatus: MapStatus = MapStatus.Builder()
                .target(cenpt)
                .zoom(12f)
                .build()

        val mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus)

        mLocationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        //检查是否授权
        if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
        ) {

            //没有授权， 请求授权
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    ),
                    PERMISSION_REQUEST_CODE
            )
        } else {  //已经授权，开启位置服务

            if (mLocationManager != null) {
                mLocationManager?.requestLocationUpdates(
                        bestProvider,
                        1000, 0f, this
                )
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mLocationManager != null) {
            mLocationManager?.removeUpdates(this)
        }
    }


    override fun onLocationChanged(location: Location) {
        val latitude = location.latitude
        val longitude = location.longitude
        val msg = "经度：  ${longitude}, 纬度：${latitude}"
        Log.i(TAG, msg)

        //创建坐标点坐标
        val point = LatLng(latitude, longitude)
        //创建Marker图标
        val bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_marka)
        //创建MarkerOption，用于在地图上添加Marker

        // 清除之前的Marker
        mBaiduMap!!.clear()

        val option: OverlayOptions = MarkerOptions()
                .position(point)
                .icon(bitmap)
        //在地图上添加Marker，并显示
        mBaiduMap!!.addOverlay(option)
    }

    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
        Log.i(TAG, "onStatusChanged...")
    }

    override fun onProviderEnabled(provider: String) {
        Log.i(TAG, "onProviderEnabled...")
    }

    override fun onProviderDisabled(provider: String) {
        Log.i(TAG, "onProviderDisabled...")

    }// 位置信息提供者条件

    //高精度
    //允许产生资费
    //低功耗
    // 获得符合条件的位置信息提供者
    private val bestProvider: String
        get() {
            val criteria = Criteria()                       // 位置信息提供者条件
            criteria.accuracy = Criteria.ACCURACY_FINE      //高精度
            criteria.isCostAllowed = true //允许产生资费
            criteria.powerRequirement = Criteria.POWER_LOW //低功耗

            var provider: String? = null
            if (mLocationManager != null) {
                // 没有授权情况下返回null
                provider = mLocationManager?.getBestProvider(criteria, false)

            }
            return provider ?: GPS_PROVIDER
        }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {   // 判断请求Code
            // 包含授权成功权限
            if (!grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                Log.i(TAG, "  授权失败...")
            } else {
                Log.i(TAG, "  授权成功...")
                // 开启位置服务
                if (mLocationManager != null) {
                    mLocationManager?.requestLocationUpdates(
                            bestProvider,
                            1000, 0f, this
                    )
                }
            }
        }
    }
}

