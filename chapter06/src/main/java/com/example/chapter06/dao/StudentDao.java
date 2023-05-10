package com.example.chapter06.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.chapter06.entity.BookInfo;
import com.example.chapter06.entity.StudentInfo;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 记录重复时替换原记录
    void insertOneBook(StudentInfo studentInfo); // 插入一条书籍信息


    @Query("SELECT * FROM StudentInfo") // 设置查询语句
    List<StudentInfo> queryAllStudent(); // 加载所有书籍信息


    @Query("DELETE FROM StudentInfo WHERE 1=1") // 设置删除语句
    void deleteAllStudents(); // 删除所有商品信息

}
