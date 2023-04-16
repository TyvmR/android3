package com.example.chapter03.imitate;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;
import com.example.chapter03.util.Utils;

public class CH322Act extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.imitate_ch3_2_2);
        Log.i("CH322Act","onResume");
    }
}
