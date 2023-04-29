package com.zhijieketang

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var mTextView: TextView? = null
    val RED_MENU_ID: Int = Menu.FIRST
    val GREEN_MENU_ID: Int = Menu.FIRST + 1
    val BLUE_MENU_ID: Int = Menu.FIRST + 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = findViewById(R.id.textview)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, RED_MENU_ID, 0, R.string.menu1)
        menu.add(0, GREEN_MENU_ID, 0, R.string.menu2)
        menu.add(0, BLUE_MENU_ID, 0, R.string.menu3)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            RED_MENU_ID -> {
                mTextView?.setBackgroundColor(Color.RED)
                mTextView?.setText(R.string.menu1)
            }
            GREEN_MENU_ID -> {
                mTextView?.setBackgroundColor(Color.YELLOW)
                mTextView?.setText(R.string.menu2)
            }

            BLUE_MENU_ID -> {
                mTextView?.setBackgroundColor(Color.BLUE)
                mTextView?.setText(R.string.menu3)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}