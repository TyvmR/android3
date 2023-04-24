package com.example.chapter03.imitate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.R;

public class ImiCalculatorActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView tv_result;
    private String firstNum;
    private String secondNum;
    private String opr;
    private String result;
    private String showText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_imi);
        findViewById(R.id.imi_btn_cancel).setOnClickListener(this); // “取消”按钮
        findViewById(R.id.imi_btn_divide).setOnClickListener(this); // “除法”按钮
        findViewById(R.id.imi_btn_muti).setOnClickListener(this); // “乘法”按钮
        findViewById(R.id.imi_btn_clear).setOnClickListener(this); // “清除”按钮
        findViewById(R.id.imi_btn_seven).setOnClickListener(this); // 数字7
        findViewById(R.id.imi_btn_eight).setOnClickListener(this); // 数字8
        findViewById(R.id.imi_btn_nine).setOnClickListener(this); // 数字9
        findViewById(R.id.imi_btn_plus).setOnClickListener(this); // “加法”按钮
        findViewById(R.id.imi_btn_four).setOnClickListener(this); // 数字4
        findViewById(R.id.imi_btn_five).setOnClickListener(this); // 数字5
        findViewById(R.id.imi_btn_six).setOnClickListener(this); // 数字6
        findViewById(R.id.imi_btn_minus).setOnClickListener(this); // “减法”按钮
        findViewById(R.id.imi_btn_one).setOnClickListener(this); // 数字1
        findViewById(R.id.imi_btn_two).setOnClickListener(this); // 数字2
        findViewById(R.id.imi_btn_three).setOnClickListener(this); // 数字3
        findViewById(R.id.imi_btn_reciprocal).setOnClickListener(this); // 求倒数按钮
        findViewById(R.id.imi_btn_zero).setOnClickListener(this); // 数字0
        findViewById(R.id.imi_btn_dot).setOnClickListener(this); // “小数点”按钮
        findViewById(R.id.imi_btn_equal).setOnClickListener(this); // “等号”按钮
        findViewById(R.id.imi_ib_sqrt).setOnClickListener(this); // “开平方”按钮
    }


    public boolean verify(View view){
        if(view.getId() == R.id.imi_btn_cancel){

        }

        return true;
    }

    private void refreshOperate(String new_result){
        result = new_result;
        firstNum = result;
        secondNum = "";
        opr = "";
    }

    private void refreshText(String text){
        showText = "";
        tv_result.setText(showText);
    }

    private void clear() {
        refreshOperate("");
        refreshText("");
    }


    private double calculateFour() {
        double calculate_result = 0;
        if (opr.equals("＋")) { // 当前是相加运算
            calculate_result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
        } else if (opr.equals("－")) { // 当前是相减运算
            calculate_result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
        } else if (opr.equals("×")) { // 当前是相乘运算
            calculate_result = Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
        } else if (opr.equals("÷")) { // 当前是相除运算
            calculate_result = Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
        return calculate_result;
    }


    @Override
    public void onClick(View v) {
        if(verify(v)){
            //暂时不增加校验逻辑
        }
        String inputText;
        if(v.getId() == R.id.imi_ib_sqrt){
            inputText = "√";
        } else {
            inputText = ((TextView)v).getText().toString();
        }
        if(v.getId() == R.id.imi_btn_cancel){
            //取消

        } else if (v.getId() == R.id.imi_btn_clear) {
            //清除
            
        } else if (v.getId() == R.id.imi_btn_muti || v.getId() == R.id.imi_btn_plus
        || v.getId() == R.id.imi_btn_divide || v.getId() == R.id.imi_btn_minus) {

        } else if(v.getId() == R.id.imi_btn_equal) {

        } else {
            //普通的数字
            refreshText(inputText);
        }
    }
}
