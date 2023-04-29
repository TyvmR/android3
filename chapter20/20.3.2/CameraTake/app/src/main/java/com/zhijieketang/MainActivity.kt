package com.zhijieketang

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileInputStream


private const val TAG = "CameraTake"

//返回数据的请求编码
private const val REQ_CODE_DATA = 100

//保存文件的请求编码
private const val REQ_CODE_SAVE = 101

//保存的图片文件名
private const val PictureFile = "test.png"

class MainActivity : AppCompatActivity() {
    // 定义mOutFile属性
    private val mOutFile: File
        get() {
            // 获得外部存储的Document目录对象
            val sdCardDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
            // 获得文件的全路径
            return File(sdCardDir, PictureFile)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 请求授权
        checkPermissions()

        val buttonTake = findViewById<Button>(R.id.buttonTake)
        buttonTake.setOnClickListener {
            //定义访问照相机意图
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //启动意图，返回请求编码为REQ_CODE_DATA
            startActivityForResult(intent, REQ_CODE_DATA)
        }

        val buttonTakeSave = findViewById<Button>(R.id.buttonTakeSave)
        buttonTakeSave.setOnClickListener {
            //定义访问照相机意图
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            // 获得保存图片的URI
            val photoURI = FileProvider.getUriForFile(
                this,
                "${BuildConfig.APPLICATION_ID}.provider", mOutFile
            )

            //设置意图附加信息
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            //启动意图，返回请求Code为REQ_CODE_SAVE
            startActivityForResult(intent, REQ_CODE_SAVE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        var bitmap: Bitmap?
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                // 单击【调用照相机】按钮返回
                REQ_CODE_DATA -> {
                    val extras = data!!.extras
                    bitmap = extras!!["data"] as Bitmap?
                    imageView.setImageBitmap(bitmap)
                }
                // 单击【调用照相机保存图片】按钮返回
                REQ_CODE_SAVE -> {
                    FileInputStream(mOutFile).use { outFileInputStream ->
                        bitmap = BitmapFactory.decodeStream(outFileInputStream)
                        imageView.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }

    // 核对权限，并请求授权
    private fun checkPermissions() {
        // 1、检查是否权限
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            || checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
            || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            // 请求的权限集合
            val permissions = arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            )
            // 2、请求授权，弹出对话框
            requestPermissions(permissions, 0)
        }
    }
}

