package com.zhijieketang

import android.Manifest.permission.*
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioManager
import android.os.Bundle
import android.provider.Settings
import android.telephony.PhoneStateListener
import android.telephony.ServiceState
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity


private const val TAG = " Blacklist"

//授权请求编码
private const val PERMISSION_REQUEST_CODE = 9

// 测试的黑名单电话列表
private val list = listOf("123", "567", "980")

class MainActivity : AppCompatActivity() {
    private var mAudioManager: AudioManager? = null
    private var mTelephonyManager: TelephonyManager? = null
    private var mNotificationManager: NotificationManager? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        mTelephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

        // 核对权限
        // 1、要检查的权限列表
        if (checkSelfPermission(READ_PHONE_STATE)
            != PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(READ_CALL_LOG)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // 需要请求的权限权限列表
            val permissions = arrayOf(
                READ_PHONE_STATE,
                ACCESS_FINE_LOCATION,
                READ_CALL_LOG
            )

            // 没有授权请求授权
            requestPermissions(permissions, PERMISSION_REQUEST_CODE)
            // 已经授权
        } else {
            Log.i(TAG, "  已经授权...")

            // 检查【勿打扰模式】是否授权
            if (mNotificationManager!!.isNotificationPolicyAccessGranted) {
            } else {
                // 未授权跳转设置界面设置
                val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
                startActivityForResult(intent, 0)
            }
            // 调用初始化函数
            initPage()

        }
    }


    // 初始化页面
    private fun initPage() {

        val listenedState = (PhoneStateListener.LISTEN_CALL_FORWARDING_INDICATOR
                or PhoneStateListener.LISTEN_CALL_STATE
                or PhoneStateListener.LISTEN_CELL_LOCATION
                or PhoneStateListener.LISTEN_DATA_ACTIVITY
                or PhoneStateListener.LISTEN_DATA_CONNECTION_STATE
                or PhoneStateListener.LISTEN_MESSAGE_WAITING_INDICATOR
                or PhoneStateListener.LISTEN_SERVICE_STATE)
        val button = findViewById<ToggleButton>(R.id.button)
        button.setOnClickListener {
            if (button.isChecked) {
                Log.i(TAG, " 黑名单开启...")
                mTelephonyManager!!
                    .listen(mPhoneStateListener, listenedState)
            } else {
                //没有监听
                Log.i(TAG, "黑名单关闭...")
                mTelephonyManager!!
                    .listen(mPhoneStateListener, PhoneStateListener.LISTEN_NONE)
            }
        }
    }

    // 创建电话状态监听器对象
    private val mPhoneStateListener = object : PhoneStateListener() {
        override fun onCallStateChanged(state: Int, incomingNumber: String) {
            when (state) {
                TelephonyManager.CALL_STATE_RINGING -> {
                    Log.i(TAG, " -> 来电状态... $incomingNumber")
                    //判断拨入的电话是否在黑名单列表中
                    if (list.contains(incomingNumber)) {
                        // 设置静音模式
                        mAudioManager!!.ringerMode = AudioManager.RINGER_MODE_SILENT
                    } else {
                        // 设置默认模式
                        mAudioManager!!.ringerMode = AudioManager.RINGER_MODE_NORMAL
                    }
                }
                TelephonyManager.CALL_STATE_IDLE -> {
                    Log.i(TAG, " -> 空闲状态...")
                }
                TelephonyManager.CALL_STATE_OFFHOOK -> {
                    Log.i(TAG, " -> 占线状态...")
                }
                else -> {
                    Log.i(TAG, " -> 默认状态...")
                }
            }
        }

        override fun onDataActivity(direction: Int) {}
        override fun onDataConnectionStateChanged(state: Int) {}
        override fun onMessageWaitingIndicatorChanged(mwi: Boolean) {}
        override fun onServiceStateChanged(serviceState: ServiceState) {}

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {   // 判断请求Code
            // 包含授权成功权限
            if (!grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                Log.i(TAG, "  授权失败...")
            } else {
                Log.i(TAG, "  授权成功...")
                // 调用初始化函数
                initPage()
            }
        }
    }
}
