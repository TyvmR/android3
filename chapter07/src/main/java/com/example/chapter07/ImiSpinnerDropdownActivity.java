package com.example.chapter07;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ImiSpinnerDropdownActivity extends AppCompatActivity {

    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_spinner_dropdown);
        initDropDownList();
    }


    public void initDropDownList(){
        // 声明一个下拉列表的数组适配器
        ArrayAdapter<String> starAdapter = new ArrayAdapter<String>(this,
                R.layout.item_select, starArray);
        Spinner spinner = findViewById(R.id.imi_sp_dropdown);
        spinner.setPrompt("请选择行星");
        spinner.setAdapter(starAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ImiSpinnerDropdownActivity.this, "您选择的是" + starArray[position],
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
