package com.example.chapterv01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_1 = this.findViewById<Button>(R.id.btn_1)
        val btn_login = this.findViewById<Button>(R.id.btn_login)

//        btn_1.setOnClickListener(object: View.OnClickListener {
//
//            override fun onClick(v: View?) {
//                val txv_1 = findViewById<TextView>(R.id.txv_1)
//                txv_1.text = "I am Changed"
//            }
//
//        })

        val btn_csv = this.findViewById<Button>(R.id.btn_csv)

        btn_1.setOnClickListener {
            val intent = Intent(this, BasicComponentAct::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            val intent = Intent(this, LoginAct::class.java)
            startActivity(intent)
        }

        btn_csv.setOnClickListener {
            val intent = Intent(this, CsvInputInfoAct::class.java)
            startActivity(intent)
        }


    }

}
