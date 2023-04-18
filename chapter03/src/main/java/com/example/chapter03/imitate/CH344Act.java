package com.example.chapter03.imitate;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

public class CH344Act extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;

    private Button ctlButton;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_4_4);
        Button enable = findViewById(R.id.imi_btn_enable);
        Button disable = findViewById(R.id.imi_btn_disable);
        ctlButton = findViewById(R.id.imi_btn_test);
        tv_result = findViewById(R.id.imi_tv_result);
        enable.setOnClickListener(this);
        disable.setOnClickListener(this);
        ctlButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imi_btn_disable){
            ctlButton.setTextColor(Color.GRAY);
            ctlButton.setEnabled(false);
        } else if (v.getId() == R.id.imi_btn_enable) {
            ctlButton.setTextColor(Color.BLACK);
            ctlButton.setEnabled(true);
        } else if (v.getId() == R.id.imi_btn_test){
            tv_result.setText("可用状态下被点击！！！");
        }

    }
}
