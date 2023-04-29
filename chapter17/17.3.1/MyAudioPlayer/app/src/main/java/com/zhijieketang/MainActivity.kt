package com.zhijieketang

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


const val TAG = "MyAudioPlayer"

//播放状态
private const val PLAYING = 0

//暂停状态
private const val PAUSE = 1

//停止状态
private const val STOP = 2

//空闲状态
private const val IDLE = 3

class MainActivity : AppCompatActivity() {
    //播放按钮
    private var play: ImageButton? = null

    //暂停按钮
    private var stop: ImageButton? = null

    //播放器对象
    private var mMediaPlayer: MediaPlayer? = null

    //当前状态
    private var state = IDLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化播放按钮
        play = findViewById(R.id.play)
        play!!.setOnClickListener {
            if (state == PLAYING) {
                pause()
            } else {
                start()
            }
        }

        // 初始化停止按钮
        stop = findViewById(R.id.stop)
        stop!!.setOnClickListener { stop() }

    }

    // 暂停
    private fun pause() {
        mMediaPlayer!!.pause()
        state = PAUSE
        play!!.setImageResource(R.mipmap.play)
    }

    // 开始
    private fun start() {
        if (state == IDLE || state == STOP) {
            play()
        } else if (state == PAUSE) {
            mMediaPlayer!!.start()
            state = PLAYING
        }
        play!!.setImageResource(R.mipmap.pause)
    }

    // 停止
    private fun stop() {
        mMediaPlayer!!.stop()
        state = STOP
        play!!.setImageResource(R.mipmap.play)
    }

    // 播放
    private fun play() {
        try {
            if (mMediaPlayer == null || state == STOP) {
                // 创建MediaPlayer对象并设置Listener
                mMediaPlayer = MediaPlayer.create(this, R.raw.ma_mma)
                mMediaPlayer!!.setOnPreparedListener(listener)
            } else {
                // 复用MediaPlayer对象
                mMediaPlayer!!.reset()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // MediaPlayer进入prepared状态开始播放
    private val listener = OnPreparedListener {
        mMediaPlayer!!.start()
        state = PLAYING
    }

    override fun onDestroy() {
        super.onDestroy()
        // Activity销毁后，释放播放器资源
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

}
