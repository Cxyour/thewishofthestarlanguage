package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ILoginContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.LoginPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;


public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginContract.ILoginView, View.OnFocusChangeListener {

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
        login_username.setOnFocusChangeListener(this);
        login_password.setOnFocusChangeListener(this);
        login_close_username.setOnClickListener(this);
        login_close_password.setOnClickListener(this);
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
                loginPresenterImp.goToLogin(login_username.getText().toString().trim(), login_password.getText().toString().trim());
                break;
            case R.id.login_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_close_username:
                login_username.setText("");
                break;
            case R.id.login_close_password:
                login_password.setText("");
                break;
        }
    }


    @Override
    public void showUserNameMessage(String string) {
        if (string != null) {
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoginMessage(UserBean userBean) {
        SharedPreferences user = getSharedPreferences("user", 0);
        SharedPreferences.Editor edit = user.edit();
        edit.putString("mobile", userBean.getData().getMobile());
        edit.putString("nickname", userBean.getData().getNickname());
        edit.putString("photo", userBean.getData().getPhoto());
        edit.putString("token", userBean.getData().getToken());
        edit.putInt("id", userBean.getData().getId());
        edit.commit();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.login_username:
                if (hasFocus) {
                    login_close_username.setVisibility(View.VISIBLE);
                } else {
                    login_close_username.setVisibility(View.GONE);
                }
                break;
            case R.id.login_password:
                if (hasFocus) {
                    login_close_password.setVisibility(View.VISIBLE);
                } else {
                    login_close_password.setVisibility(View.GONE);
                }
                break;
        }
    }
}
