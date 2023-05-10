package com.example.chapter06;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter06.dao.BookDao;
import com.example.chapter06.dao.StudentDao;
import com.example.chapter06.entity.BookInfo;
import com.example.chapter06.entity.StudentInfo;
import com.example.chapter06.util.ToastUtil;

import java.util.List;

public class RoomReadActivityImi extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_room; // 声明一个文本视图对象
    private StudentDao studentDao; // 声明一个书籍的持久化对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_read);
        tv_room = findViewById(R.id.tv_room);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        // 从App实例中获取唯一的书籍持久化对象
        studentDao = MainApplication.getInstance().getStudentDb().studentDao();
        readRoom(); // 读取数据库中的所有书籍记录
    }

    // 读取数据库中的所有书籍记录
    private void readRoom() {
        List<StudentInfo> studentInfos = studentDao.queryAllStudent(); // 获取所有书籍记录
        String desc = String.format("数据库查询到%d条记录，详情如下：", studentInfos.size());
        for (int i = 0; i < studentInfos.size(); i++) {
            StudentInfo info = studentInfos.get(i);
            desc = String.format("%s\n第%d条记录信息如下：", desc, i + 1);
            desc = String.format("%s\n　主键ID%s", desc, info.getId());
            desc = String.format("%s\n　姓名为《%s》", desc, info.getName());
            desc = String.format("%s\n　年龄为%s", desc, info.getAge());

        }
        if (studentInfos.size() <= 0) {
            desc = "数据库查询到的记录为空";
        }
        tv_room.setText(desc);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_delete) {
            studentDao.deleteAllStudents(); // 删除所有书籍记录
            ToastUtil.show(this, "已删除所有记录");
            readRoom(); // 读取数据库中的所有书籍记录
        }
    }

}