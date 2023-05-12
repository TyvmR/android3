package com.example.chapter07;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter07.adapter.PlanetListAdapter;
import com.example.chapter07.adapter.PlanetListAdapterImi;
import com.example.chapter07.bean.Planet;
import com.example.chapter07.util.Utils;

import java.util.List;

public class ImiListViewActivity extends AppCompatActivity  {
    private final static String TAG = "ImiListViewActivity";

    private CheckBox ck_divider;
    private CheckBox ck_selector;
    private ListView lv_list;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imi_activity_list_view);
        lv_list= findViewById(R.id.imi_lv_planet);
        ck_selector = findViewById(R.id.imi_ck_selector);
        ck_divider = findViewById(R.id.imi_ck_divider);
        ck_selector.setOnCheckedChangeListener( (v,f) -> {
            refreshListView();
        });
        ck_divider.setOnCheckedChangeListener( (v,f) -> {
            refreshListView();
        });
        PlanetListAdapterImi planetListAdapterImi = new PlanetListAdapterImi(this,Planet.getDefaultList());
        lv_list.setAdapter(planetListAdapterImi);
        lv_list.setOnItemClickListener(planetListAdapterImi);
        lv_list.setOnItemLongClickListener(planetListAdapterImi);
    }


    // 刷新列表视图
    private void refreshListView() {
        if(ck_divider.isChecked()){
            Drawable drawable = getResources().getDrawable(R.color.red);
            lv_list.setDivider(drawable);
            lv_list.setDividerHeight(Utils.dip2px(this,5));
        } else {
            lv_list.setDivider(null);
            lv_list.setDividerHeight(0);
        }

        if(ck_selector.isChecked()){
            lv_list.setSelector(R.drawable.list_selector);
        } else {
            Drawable drawable = getResources().getDrawable(R.color.transparent);
            lv_list.setSelector(drawable); // 设置列表项的按压状态图形
        }
    }

}
