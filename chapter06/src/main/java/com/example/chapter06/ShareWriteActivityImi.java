package com.example.chapter06;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter06.util.DateUtil;
import com.example.chapter06.util.ToastUtil;

public class ShareWriteActivityImi extends AppCompatActivity implements View.OnClickListener {


    private SharedPreferences mShared; // 声明一个共享参数对象
    private EditText et_name; // 声明一个编辑框对象
    private EditText et_age; // 声明一个编辑框对象
    private EditText et_height; // 声明一个编辑框对象
    private EditText et_weight; // 声明一个编辑框对象
    private boolean isMarried = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_write);
        et_name = findViewById(R.id.et_name);
        et_name.setOnClickListener(this);
        et_age = findViewById(R.id.et_age);
        et_age.setOnClickListener(this);
        et_height = findViewById(R.id.et_height);
        et_height.setOnClickListener(this);
        et_weight = findViewById(R.id.et_weight);
        et_weight.setOnClickListener(this);
        CheckBox checkBox = findViewById(R.id.ck_married);
        Button btn = findViewById(R.id.btn_save);
        btn.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isMarried = isChecked;
            }
        });
        mShared = getSharedPreferences("share", MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_save){
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if (TextUtils.isEmpty(name)) {
                ToastUtil.show(this, "请先填写姓名");
                return;
            } else if (TextUtils.isEmpty(age)) {
                ToastUtil.show(this, "请先填写年龄");
                return;
            } else if (TextUtils.isEmpty(height)) {
                ToastUtil.show(this, "请先填写身高");
                return;
            } else if (TextUtils.isEmpty(weight)) {
                ToastUtil.show(this, "请先填写体重");
                return;
            }
            SharedPreferences.Editor editor = mShared.edit();
            editor.putString("name", name); // 添加一个名叫name的字符串参数
            editor.putInt("age", Integer.parseInt(age)); // 添加一个名叫age的整型参数
            editor.putLong("height", Long.parseLong(height)); // 添加一个名叫height的长整型参数
            editor.putFloat("weight", Float.parseFloat(weight)); // 添加一个名叫weight的浮点数参数
            editor.putBoolean("married", isMarried); // 添加一个名叫married的布尔型参数
            editor.putString("update_time", DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            editor.commit(); // 提交编辑器中的修改
            ToastUtil.show(this, "IMI数据已写入共享参数");
        }
    }
}
