package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //改造部分: 增加跳转
        new Handler(Looper.myLooper()).postDelayed(() -> {
            startActivity(new Intent(Main2Activity.this,Main3Activity.class));
        },3000);

    }
}
