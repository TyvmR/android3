package com.example.chapter03.imitate;


import android.graphics.Color;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

public class CH313TextColorAct extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_1_3);
        TextView viewById = findViewById(R.id.imi_ch3_3);
        viewById.setBackgroundColor(Color.GREEN);
    }



}
