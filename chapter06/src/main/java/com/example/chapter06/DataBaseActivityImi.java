package com.example.chapter06;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataBaseActivityImi extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_database;

    private String mdatabaseName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_imi);
        findViewById(R.id.btn_database_create).setOnClickListener(this);
        findViewById(R.id.btn_database_delete).setOnClickListener(this);
        tv_database = findViewById(R.id.tv_database);
        // 生成一个测试数据库的完整路径
        mdatabaseName = getFilesDir() + "/test.db";
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_database_create){
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(mdatabaseName, Context.MODE_PRIVATE, null);
             tv_database.setText(String.format("数据库%s创建%s",sqLiteDatabase.getPath(),sqLiteDatabase!=null?"成功":"失败"));
        } else if (v.getId() == R.id.btn_database_delete){
            boolean b = deleteDatabase(mdatabaseName);
            tv_database.setText(String.format("数据库%s删除%s",mdatabaseName,b?"成功":"失败"));
        }
    }
}
