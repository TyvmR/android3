package com.example.chapter06.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.chapter06.dao.GoodsDao;
import com.example.chapter06.dao.StudentDao;
import com.example.chapter06.entity.BookInfo;
import com.example.chapter06.entity.StudentInfo;

@Database(entities = {StudentInfo.class},version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();

}
