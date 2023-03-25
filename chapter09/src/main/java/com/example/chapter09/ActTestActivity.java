package com.example.chapter09;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter09.util.DateUtil;

public class ActTestActivity extends AppCompatActivity {
    private final static String TAG = "ActTestActivity";
    private TextView tv_life; // 声明一个文本视图对象
    private String mStr = "";

    private void refreshLife(String desc) { // 刷新生命周期的日志信息
        Log.d(TAG, desc);
        mStr = String.format("%s%s %s %s\n", mStr, DateUtil.getNowTimeDetail(), TAG, desc);
        tv_life.setText(mStr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 创建活动页面
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_test);
        tv_life = findViewById(R.id.tv_life);
        refreshLife("onCreate");
    }

    @Override
    protected void onStart() { // 开始活动页面
        super.onStart();
        refreshLife("onStart");
    }

    @Override
    protected void onStop() { // 停止活动页面
        super.onStop();
        refreshLife("onStop");
    }

    @Override
    protected void onResume() { // 恢复活动页面
        super.onResume();
        refreshLife("onResume");
    }

    @Override
    protected void onPause() { // 暂停活动页面
        super.onPause();
        refreshLife("onPause");
    }

    @Override
    protected void onRestart() { // 重启活动页面
        super.onRestart();
        refreshLife("onRestart");
    }

    @Override
    protected void onDestroy() { // 销毁活动页面
        super.onDestroy();
        refreshLife("onDestroy");
    }

}
