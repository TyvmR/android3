package com.example.chapter03.imitate;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

public class CH351Act extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_5_1);
        imageView = findViewById(R.id.imi_iv_scale);
        Button button_fc = findViewById(R.id.imi_btn_fitCenter);
        Button button_c = findViewById(R.id.imi_btn_center);
        Button button_cc = findViewById(R.id.imi_btn_centerCrop);
        Button button_ci = findViewById(R.id.imi_btn_centerInside);
        Button button_fxy = findViewById(R.id.imi_btn_fitXY);
        Button button_fs = findViewById(R.id.imi_btn_fitStart);
        Button button_fe = findViewById(R.id.imi_btn_fitEnd);
        button_fc.setOnClickListener(this);
        button_c.setOnClickListener(this);
        button_cc.setOnClickListener(this);
        button_ci.setOnClickListener(this);
        button_fxy.setOnClickListener(this);
        button_fs.setOnClickListener(this);
        button_fe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imi_btn_fitCenter){
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if(v.getId() == R.id.imi_btn_center){
            imageView.setScaleType(ImageView.ScaleType.CENTER);
        }
        if(v.getId() == R.id.imi_btn_centerCrop){
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if(v.getId() == R.id.imi_btn_centerInside){
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        if(v.getId() == R.id.imi_btn_fitXY){
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if(v.getId() == R.id.imi_btn_fitStart){
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
        }
        if(v.getId() == R.id.imi_btn_fitEnd){
            imageView.setScaleType(ImageView.ScaleType.FIT_END);
        }
    }
}
