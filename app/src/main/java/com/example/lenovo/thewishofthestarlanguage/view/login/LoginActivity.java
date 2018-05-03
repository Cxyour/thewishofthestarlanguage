package com.example.lenovo.thewishofthestarlanguage.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView login_goto_weixin;
    private TextView login_goto_qq;
    private TextView login_goto_sina;
    private EditText login_username;
    private ImageView login_close_username;
    private EditText login_password;
    private ImageView login_close_password;
    private TextView login_forget_password;
    private Button login_login;
    private TextView login_close;
    private TextView login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        login_goto_weixin = (TextView) findViewById(R.id.login_goto_weixin);
        login_goto_qq = (TextView) findViewById(R.id.login_goto_qq);
        login_goto_sina = (TextView) findViewById(R.id.login_goto_sina);
        login_username = (EditText) findViewById(R.id.login_username);
        login_close_username = (ImageView) findViewById(R.id.login_close_username);
        login_password = (EditText) findViewById(R.id.login_password);
        login_close_password = (ImageView) findViewById(R.id.login_close_password);
        login_forget_password = (TextView) findViewById(R.id.login_forget_password);
        login_login = (Button) findViewById(R.id.login_login);
        login_close = (TextView) findViewById(R.id.login_close);
        login_register = (TextView) findViewById(R.id.login_register);
        login_register.setOnClickListener(this);
        login_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:

                break;
            case R.id.login_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                break;
        }
    }


}
