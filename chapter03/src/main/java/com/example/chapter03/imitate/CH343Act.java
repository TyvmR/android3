package com.example.chapter03.imitate;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

public class CH343Act extends AppCompatActivity implements View.OnLongClickListener {

    private TextView textView;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_4_3);
        textView = findViewById(R.id.imi_tv_result);
        Button btn_single = findViewById(R.id.imi_btn_longclick_single);
        Button btn_public = findViewById(R.id.imi_btn_longclick_public);
        btn_single.setOnLongClickListener(this);
        btn_public.setOnLongClickListener(new MyLongClickListener());
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId() == R.id.imi_btn_longclick_single){
            textView.setText("私有长按监听器！！！");
            return true;
        }
        return false;

    }


    class MyLongClickListener implements View.OnLongClickListener {


        @Override
        public boolean onLongClick(View v) {
            if(v.getId() == R.id.imi_btn_longclick_public){
                textView.setText("共有长按监听器！！！");
                return true;
            }
            return false;
        }
    }
}
