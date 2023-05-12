package com.example.chapter06;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter06.util.ViewUtil;

import java.util.Random;

public class LoginShareActivityImi extends AppCompatActivity implements View.OnClickListener {


    private RadioGroup radioGroup;

    private TextView tv_password;

    private Button forget_sent_btn;
    
    private EditText ed_password;

    private EditText ed_phone_number;

    private CheckBox ck_remember;

    private boolean isRemember = false;
    private int mRequestCode = 0;

    private RadioButton password;
    private RadioButton verifyCode;

    private String pd = "111111";

    private String mVerifyCode;

    private Button imi_login;

    private SharedPreferences mShared;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_share_imi);
        radioGroup = findViewById(R.id.imi_gp_login);
        tv_password = findViewById(R.id.tv_password);
        forget_sent_btn = findViewById(R.id.forget_sent_btn);
        forget_sent_btn.setOnClickListener(this);
        imi_login = findViewById(R.id.imi_login);
        password = findViewById(R.id.imi_lg_by_passwd);
        verifyCode = findViewById(R.id.imi_lg_by_verfy_code);
        imi_login.setOnClickListener(this);
        ed_password = findViewById(R.id.ed_password);
        ed_phone_number = findViewById(R.id.ed_phone_number);
        ck_remember = findViewById(R.id.remember_password);
        ck_remember.setOnCheckedChangeListener((v1,v2) -> isRemember = v2);
        mShared = getSharedPreferences("share_login",MODE_PRIVATE);

        ed_phone_number.addTextChangedListener(new LoginShareActivityImi.TextHideWatcher(ed_phone_number, 11));
        // 给et_password添加文本变更监听器
        ed_password.addTextChangedListener(new LoginShareActivityImi.TextHideWatcher(ed_password, 11));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.imi_lg_by_passwd){
                    tv_password.setText("登录密码：");
                    forget_sent_btn.setText("忘记密码");
                    ed_password.setHint("请输入密码");
                    ck_remember.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.imi_lg_by_verfy_code){
                    tv_password.setText("　验证码：");
                    forget_sent_btn.setText("获取验证码");
                    ed_password.setHint("请输入验证码");
                    ck_remember.setVisibility(View.INVISIBLE);
                }
            }
        });

        String phone = mShared.getString("phone", "");
        // 获取共享参数保存的密码
        String password = mShared.getString("password", "");
        ed_phone_number.setText(phone); // 往手机号码编辑框填写上次保存的手机号
        ed_password.setText(password); // 往密码编辑框填写上次保存的密码
    }


    @Override
    public void onClick(View v) {
        String phone = ed_phone_number.getText().toString();

        if(v.getId() == R.id.forget_sent_btn){
            if(phone.length() < 11){
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            if(password.isChecked()){
                Intent intent = new Intent(this, LoginForgetActivity.class);
                intent.putExtra("phone", phone);
                startActivityForResult(intent, mRequestCode);
            } else if (verifyCode.isChecked()) {
                mVerifyCode = String.format("%06d", new Random().nextInt(999999));
                // 以下弹出提醒对话框，提示用户记住六位验证码数字
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请记住验证码");
                builder.setMessage("手机号" + phone + "，本次验证码是" + mVerifyCode + "，请输入验证码");
                builder.setPositiveButton("好的", null);
                AlertDialog alert = builder.create();
                alert.show(); // 显示提醒对话框
            }


        } else if (v.getId() == R.id.imi_login) {
            if (phone.length() < 11) { // 手机号码不足11位
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isChecked()) { // 密码方式校验
                if (!ed_password.getText().toString().equals(pd)) {
                    Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                } else { // 密码校验通过
                    loginSuccess(); // 提示用户登录成功
                }
            } else if (verifyCode.isChecked()) { // 验证码方式校验
                if (!ed_password.getText().toString().equals(mVerifyCode)) {
                    Toast.makeText(this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
                } else { // 验证码校验通过
                    loginSuccess(); // 提示用户登录成功
                }
            }
        }
    }


    private void loginSuccess() {
        String desc = String.format("您的手机号码是%s，恭喜你通过登录验证，点击“确定”按钮返回上个页面",
                ed_phone_number.getText().toString());
        // 以下弹出提醒对话框，提示用户登录成功
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录成功");
        builder.setMessage(desc);
        builder.setPositiveButton("确定返回", (dialog, which) -> finish());
        builder.setNegativeButton("我再看看", null);
        AlertDialog alert = builder.create();
        alert.show(); // 显示提醒对话框
        // 如果勾选了“记住密码”，就把手机号码和密码都保存到共享参数中
        if (isRemember) {
            SharedPreferences.Editor editor = mShared.edit(); // 获得编辑器的对象
            editor.putString("phone", ed_phone_number.getText().toString()); // 添加名叫phone的手机号码
            editor.putString("password", ed_password.getText().toString()); // 添加名叫password的密码
            editor.commit(); // 提交编辑器中的修改
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == mRequestCode && data != null) {
            pd = data.getStringExtra("new_password");
        }
    }

    class TextHideWatcher implements TextWatcher{

        private EditText mView; // 声明一个编辑框对象
        private int mMaxLength; // 声明一个最大长度变量

        public TextHideWatcher(EditText v, int maxLength) {
            super();
            mView = v;
            mMaxLength = maxLength;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString(); // 获得已输入的文本字符串
            if ((str.length() == 11 && mMaxLength == 11)
                    || (str.length() == 6 && mMaxLength == 6)) {
                ViewUtil.hideOneInputMethod(LoginShareActivityImi.this, mView); // 隐藏输入法软键盘
            }
        }
    }
}
