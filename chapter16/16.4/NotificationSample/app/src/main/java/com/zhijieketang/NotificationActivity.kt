package com.zhijieketang

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        // 取消显示在通知列表中的指定通知
        mNotificationManager.cancel(NOTIFY_ME_ID)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}

