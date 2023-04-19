package com.example.chapter04.imitate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter04.R;

public class CH4_1_2_FinishActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_4_1_1_finished);
        Button btn_finished = findViewById(R.id.imi_btn_finish);
        btn_finished.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
