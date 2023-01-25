package com.example.chapterv01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            val user = findViewById<TextView>(R.id.user)
            val pass = findViewById<TextView>(R.id.password)
            if(user?.text.toString() == "tony" && pass?.text.toString() == "123"){
                println("登录成功")
                val intent = Intent(this, LoginSuccessAct::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, LoginFailAct::class.java)
                startActivity(intent)
            }
        }

    }
}
