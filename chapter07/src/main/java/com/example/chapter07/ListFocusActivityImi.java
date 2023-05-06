package com.example.chapter07;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter07.adapter.PlanetListWithButtonAdapterImi;
import com.example.chapter07.bean.Planet;

import java.util.List;

public class ListFocusActivityImi extends AppCompatActivity {

    private String[] focusArray = {
            "在子控件之前处理",
            "在子控件之后处理",
            "不让子控件处理",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //此处读取布局文件
        setContentView(R.layout.activity_list_focus_imi);
        Spinner spinner = findViewById(R.id.focus_type_spinner_imi);

        //准备下拉列表适配器
        ArrayAdapter<String> spinnerAdapter =  new ArrayAdapter<>(this,R.layout.item_select,focusArray);
        spinner.setPrompt("请选择焦点抢占方式");
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    showListView(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
                } else if(position == 1){
                    showListView(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                } else if(position == 2){
                    showListView(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void showListView(int focusType){
        List<Planet> planetList = Planet.getDefaultList();
        ListView lv = findViewById(R.id.imi_lv_planet);
        PlanetListWithButtonAdapterImi adapterImi = new PlanetListWithButtonAdapterImi(planetList,this,focusType);
        lv.setAdapter(adapterImi);
        lv.setOnItemClickListener(adapterImi);
        lv.setOnItemLongClickListener(adapterImi);
    }
}
