package com.example.chapter07;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImiSpinnerIconActivity extends AppCompatActivity {



    // 定义下拉列表需要显示的行星图标数组
    private int[] iconArray = {R.drawable.shuixing, R.drawable.jinxing, R.drawable.diqiu,
            R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};
    // 定义下拉列表需要显示的行星名称数组
    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_spinner_icon);
        initSpinnerForSimpleAdapter();

    }

    // 初始化下拉框，演示简单适配器
    private void initSpinnerForSimpleAdapter() {
        List<Map<String,Object>> itemList = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            Map<String,Object> item = new HashMap<>();
            item.put("icon",iconArray[i]);
            item.put("name",starArray[i]);
            itemList.add(item);
        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(this,itemList,R.layout.item_simple,new String[]{"icon","name"},new int[]{R.id.iv_icon,R.id.tv_name});
        Spinner spinner = findViewById(R.id.imi_sp_icon);
        spinner.setPrompt("请选择行星");
        spinner.setAdapter(simpleAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ImiSpinnerIconActivity.this,"您选择的是" + starArray[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }




}
