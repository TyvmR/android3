package com.example.chapter03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.imitate.CH311TextShowAct;
import com.example.chapter03.imitate.CH12TextSizeAct;
import com.example.chapter03.imitate.CH313TextColorAct;
import com.example.chapter03.imitate.CH321Act;
import com.example.chapter03.imitate.CH322Act;
import com.example.chapter03.imitate.CH323Act;
import com.example.chapter03.imitate.CH331_1Act;
import com.example.chapter03.imitate.CH331_2Act;
import com.example.chapter03.imitate.CH332Act;
import com.example.chapter03.imitate.CH333Act;
import com.example.chapter03.imitate.CH334Act;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_text_view).setOnClickListener(this);
        findViewById(R.id.btn_text_size).setOnClickListener(this);
        findViewById(R.id.btn_text_color).setOnClickListener(this);
        findViewById(R.id.imi_btn_text_view).setOnClickListener(this);
        findViewById(R.id.imi_btn_text_size).setOnClickListener(this);
        findViewById(R.id.imi_btn_text_color).setOnClickListener(this);



        findViewById(R.id.btn_view_border).setOnClickListener(this);
        findViewById(R.id.btn_view_margin).setOnClickListener(this);
        findViewById(R.id.btn_view_gravity).setOnClickListener(this);
        findViewById(R.id.imi_btn_view_border).setOnClickListener(this);
        findViewById(R.id.imi_btn_view_margin).setOnClickListener(this);
        findViewById(R.id.imi_btn_view_gravity).setOnClickListener(this);


        findViewById(R.id.btn_linear_layout).setOnClickListener(this);
        findViewById(R.id.btn_linear_weight).setOnClickListener(this);
        findViewById(R.id.btn_grid_layout).setOnClickListener(this);
        findViewById(R.id.btn_relative_layout).setOnClickListener(this);
        findViewById(R.id.btn_scroll_view).setOnClickListener(this);
        findViewById(R.id.imi_btn_linear_layout).setOnClickListener(this);
        findViewById(R.id.imi_btn_linear_weight).setOnClickListener(this);
        findViewById(R.id.imi_btn_grid_layout).setOnClickListener(this);
        findViewById(R.id.imi_btn_relative_layout).setOnClickListener(this);
        findViewById(R.id.imi_btn_scroll_view).setOnClickListener(this);



        findViewById(R.id.btn_button_style).setOnClickListener(this);
        findViewById(R.id.btn_button_click).setOnClickListener(this);
        findViewById(R.id.btn_button_longclick).setOnClickListener(this);
        findViewById(R.id.btn_button_enable).setOnClickListener(this);
        findViewById(R.id.btn_image_scale).setOnClickListener(this);
        findViewById(R.id.btn_image_button).setOnClickListener(this);
        findViewById(R.id.btn_image_text).setOnClickListener(this);
        findViewById(R.id.btn_calculator).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_text_view) {
            Intent intent = new Intent(this, TextViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_text_size) {
            Intent intent = new Intent(this, TextSizeActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_text_color) {
            Intent intent = new Intent(this, TextColorActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_text_view) {
            Intent intent = new Intent(this, CH311TextShowAct.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_text_size) {
            Intent intent = new Intent(this, CH12TextSizeAct.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_text_color) {
            Intent intent = new Intent(this, CH313TextColorAct.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_view_border) {
            Intent intent = new Intent(this, CH321Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_view_margin) {
            Intent intent = new Intent(this, CH322Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_view_gravity) {
            Intent intent = new Intent(this, CH323Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_view_border) {
            Intent intent = new Intent(this, ViewBorderActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_view_margin) {
            Intent intent = new Intent(this, ViewMarginActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_view_gravity) {
            Intent intent = new Intent(this, ViewGravityActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_linear_layout) {
            Intent intent = new Intent(this, CH331_1Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_linear_weight) {
            Intent intent = new Intent(this, CH331_2Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_grid_layout) {
            Intent intent = new Intent(this, CH333Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_relative_layout) {
            Intent intent = new Intent(this, CH332Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.imi_btn_scroll_view) {
            Intent intent = new Intent(this, CH334Act.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_linear_layout) {
            Intent intent = new Intent(this, LinearLayoutActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_linear_weight) {
            Intent intent = new Intent(this, LinearWeightActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_grid_layout) {
            Intent intent = new Intent(this, GridLayoutActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_relative_layout) {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_scroll_view) {
            Intent intent = new Intent(this, ScrollViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_button_style) {
            Intent intent = new Intent(this, ButtonStyleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_button_click) {
            Intent intent = new Intent(this, ButtonClickActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_button_longclick) {
            Intent intent = new Intent(this, ButtonLongclickActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_button_enable) {
            Intent intent = new Intent(this, ButtonEnableActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_image_scale) {
            Intent intent = new Intent(this, ImageScaleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_image_button) {
            Intent intent = new Intent(this, ImageButtonActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_image_text) {
            Intent intent = new Intent(this, ImageTextActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_calculator) {
            Intent intent = new Intent(this, CalculatorActivity.class);
            startActivity(intent);
        }
    }

}
