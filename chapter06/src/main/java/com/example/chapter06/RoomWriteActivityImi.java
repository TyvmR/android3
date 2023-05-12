package com.example.chapter06;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter06.dao.BookDao;
import com.example.chapter06.dao.StudentDao;
import com.example.chapter06.entity.BookInfo;
import com.example.chapter06.entity.StudentInfo;
import com.example.chapter06.util.ToastUtil;

public class RoomWriteActivityImi extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name; // 声明一个编辑框对象
    private EditText et_age; // 声明一个编辑框对象

    private StudentDao studentDao; // 声明一个书籍的持久化对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_write_imi);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        findViewById(R.id.btn_save).setOnClickListener(this);
        // 从App实例中获取唯一的书籍持久化对象
        studentDao = MainApplication.getInstance().getStudentDb().studentDao();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save) {
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            StudentInfo info = new StudentInfo();
            info.setName(name);
            info.setAge(Integer.parseInt(age));
            studentDao.insertOneBook(info); // 往数据库插入一条书籍记录
            ToastUtil.show(this, "数据已写入Room数据库");
        }
    }

}