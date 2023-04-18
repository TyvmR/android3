package com.example.chapter03.imitate;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

import java.time.LocalDateTime;

public class CH341Act extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_4_1);
        tv_result = findViewById(R.id.imi_tv_result);
    }

    public void doClick(View view){
        tv_result.setText("您点击了按钮" + LocalDateTime.now());
    }
}
