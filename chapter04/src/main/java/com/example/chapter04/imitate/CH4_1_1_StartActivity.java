package com.example.chapter04.imitate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter04.R;

public class CH4_1_1_StartActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_4_1_1_start);
        Button btn_start = findViewById(R.id.imi_btn_act_start);
        btn_start.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.d("----","Click Me");
        startActivity(new Intent(this,CH4_1_2_FinishActivity.class));
    }
}
