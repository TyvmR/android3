package com.example.chapter07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter07.adapter.PlanetGridAdapter;
import com.example.chapter07.bean.Planet;
import com.example.chapter07.util.Utils;

import java.util.List;

public class GridViewActivityImi extends AppCompatActivity {

    private GridView gv_planet;
    private String[] dividerArray = {
            "不显示分隔线",
            "不拉伸(NO_STRETCH)",
            "拉伸列宽(COLUMN_WIDTH)",
            "列间空隙(STRETCH_SPACING)",
            "左右空隙(SPACING_UNIFORM)",
            "使用padding显示全部分隔线"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_imi);
        gv_planet = findViewById(R.id.imi_gridview_list);
        List<Planet> planetList = Planet.getDefaultList();
        // 构建一个行星列表的网格适配器
        PlanetGridAdapter adapter = new PlanetGridAdapter(this, planetList);
        // 从布局视图中获取名叫gv_planet的网格视图
        gv_planet.setAdapter(adapter); // 设置网格视图的适配器
        gv_planet.setOnItemClickListener(adapter); // 设置网格视图的点击监听器
        gv_planet.setOnItemLongClickListener(adapter);
        initSpinner();
    }


    public void initSpinner(){
        Spinner spinner =  findViewById(R.id.imi_grid_view_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.item_select,dividerArray);
        spinner.setAdapter(arrayAdapter); // 设置下拉框的数组适配器
        spinner.setSelection(0);
        spinner.setPrompt("请选择拉伸模式");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int arg2, long id) {
                int dividerPad = Utils.dip2px(GridViewActivityImi.this, 2);
                gv_planet.setBackgroundColor(Color.CYAN);  // 设置背景颜色
                gv_planet.setHorizontalSpacing(dividerPad);  // 设置列表项在水平方向的间距
                gv_planet.setVerticalSpacing(dividerPad);  // 设置列表项在垂直方向的间距
                gv_planet.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);  // 设置拉伸模式
                gv_planet.setColumnWidth(Utils.dip2px(GridViewActivityImi.this, 120));  // 设置每列宽度为120dp
                gv_planet.setPadding(0, 0, 0, 0);
                if (arg2 == 0) {  // 不显示分隔线
                    gv_planet.setBackgroundColor(Color.WHITE);
                    gv_planet.setHorizontalSpacing(0);
                    gv_planet.setVerticalSpacing(0);
                } else if (arg2 == 1) {  // 不拉伸(NO_STRETCH)
                    gv_planet.setStretchMode(GridView.NO_STRETCH);
                } else if (arg2 == 2) {  // 拉伸列宽(COLUMN_WIDTH)
                    gv_planet.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
                } else if (arg2 == 3) {  // 列间空隙(STRETCH_SPACING)
                    gv_planet.setStretchMode(GridView.STRETCH_SPACING);
                } else if (arg2 == 4) {  // 左右空隙(SPACING_UNIFORM)
                    gv_planet.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
                } else if (arg2 == 5) {  // 使用padding显示全部分隔线
                    gv_planet.setPadding(dividerPad, dividerPad, dividerPad, dividerPad);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }







}
