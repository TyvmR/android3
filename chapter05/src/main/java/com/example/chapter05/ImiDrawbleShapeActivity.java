package com.example.chapter05;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImiDrawbleShapeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_drawable_shape);
        View viewById = findViewById(R.id.imi_v_content);
        findViewById(R.id.imi_btn_oval).setOnClickListener( v -> {
            viewById.setBackgroundResource(R.drawable.imi_shape_rect_gold);
        });

        findViewById(R.id.imi_btn_rect).setOnClickListener( v -> {
            viewById.setBackgroundResource(R.drawable.imi_shape_oval_rose);

        });
    }


}
