package com.example.chapter07;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter07.adapter.ImiPlanetBaseAdapter;
import com.example.chapter07.adapter.PlanetBaseAdapter;
import com.example.chapter07.bean.Planet;

import java.util.List;

public class ImiBaseAdapterActivity extends AppCompatActivity {
    private List<Planet> planetList; // 声明一个行星列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_base_adapter);
        initPlanetSpinner(); // 初始化行星列表的下拉框
    }

    // 初始化行星列表的下拉框
    private void initPlanetSpinner() {
        planetList = Planet.getDefaultList();
        ImiPlanetBaseAdapter imiPlanetBaseAdapter = new ImiPlanetBaseAdapter(this, planetList);
        // 从布局文件中获取名叫sp_planet的下拉框
        Spinner sp_planet = findViewById(R.id.sp_planet);
        sp_planet.setPrompt("请选择行星"); // 设置下拉框的标题
        sp_planet.setAdapter(imiPlanetBaseAdapter); // 设置下拉框的列表适配器
        sp_planet.setSelection(0); // 设置下拉框默认显示第一项
        sp_planet.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ImiBaseAdapterActivity.this,"您选择的是" + planetList.get(position).name,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
