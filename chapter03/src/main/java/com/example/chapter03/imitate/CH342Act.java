package com.example.chapter03.imitate;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

public class CH342Act extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_4_2);
        Button btn_private = findViewById(R.id.imi_btn_click_single);
        btn_private.setOnClickListener(this);
        textView = findViewById(R.id.imi_tv_result);

        Button btn_public = findViewById(R.id.imi_btn_click_public);

        btn_public.setOnClickListener(new MyClickListener());
    }



    @Override
    public void onClick(View v) {
        Log.d("CH342Act","私有监听事件触发");
        textView.setText("点击了私有监听器！！！");
    }

    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            textView.setText("公共监听器被触发!!!");
        }
    }
}
