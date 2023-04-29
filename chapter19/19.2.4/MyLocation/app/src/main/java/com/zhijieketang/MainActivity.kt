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


private const val TAG = "MyLocation"

//授权请求编码
private const val PERMISSION_REQUEST_CODE = 999

class MainActivity : AppCompatActivity(), LocationListener {
    private var mLatitude: TextView? = null
    private var mLongitude: TextView? = null
    private var mAltitude: TextView? = null

    //定位服务管理类
    private var mLocationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLatitude = findViewById(R.id.textView_latitude)
        mLongitude = findViewById(R.id.textView_longitude)
        mAltitude = findViewById(R.id.textView_altitude)

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
        val altitude = location.altitude
        val msg = "经度：  ${longitude}, 纬度：${latitude}, 海拔高度：${altitude}"
        Log.i(TAG, msg)

        mLatitude!!.text = "%.4f".format(latitude)
        mLongitude!!.text = "%.4f".format(longitude)
        mAltitude!!.text = altitude.toString()
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

