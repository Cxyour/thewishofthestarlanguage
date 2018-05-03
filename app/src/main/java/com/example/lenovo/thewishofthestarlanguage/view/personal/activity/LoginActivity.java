package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ILoginContact;
import com.example.lenovo.thewishofthestarlanguage.presenter.LoginPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;


public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginContact.ILoginView {

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
    private LoginPresenterImp loginPresenterImp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
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
    protected void loadData() {
        loginPresenterImp = new LoginPresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                loginPresenterImp.getLoginMessage(login_username.getText().toString().trim(), login_password.getText().toString().trim());
                break;
            case R.id.login_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }



    @Override
    public void showLoginMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
