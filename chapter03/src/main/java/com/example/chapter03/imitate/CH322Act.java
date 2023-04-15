package com.example.chapter03.imitate;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;
import com.example.chapter03.util.Utils;

public class CH322Act extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_2_1);
        TextView viewById = findViewById(R.id.imi_ch_3_2_1_code_with);
        ViewGroup.LayoutParams layoutParams = viewById.getLayoutParams();
        layoutParams.width = Utils.dip2px(this,300);
        viewById.setLayoutParams(layoutParams);

    }
}
