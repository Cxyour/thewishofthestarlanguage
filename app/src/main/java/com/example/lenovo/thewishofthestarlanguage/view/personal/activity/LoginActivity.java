package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;


import android.content.Context;
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
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
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
    private Intent intent;
    private Intent iiii;

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
        login_close.setOnClickListener(this);
        login_forget_password.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        loginPresenterImp = new LoginPresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                if (!loginPresenterImp.isUserName(login_username.getText().toString().trim()))
                    return;
                loginPresenterImp.goToLogin(login_username.getText().toString().trim(), login_password.getText().toString().trim());

                break;
            case R.id.login_register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_close_username:
                login_username.setText("");
                break;
            case R.id.login_close_password:
                login_password.setText("");
                break;
            case R.id.login_close:
                finish();
                break;
            case R.id.login_forget_password:
                intent = new Intent(this, FindPassWordActivity.class);
                startActivity(intent);
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
        if (userBean.getMessage().equals("cid为空")) {
            SharedPreferences user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = user.edit();
            edit.putString(Constant.User_mobile, userBean.getData().getMobile());
            edit.putString(Constant.User_name, userBean.getData().getNickname());
            edit.putString(Constant.User_icon, userBean.getData().getPhoto());
            edit.putInt(Constant.UserId, userBean.getData().getId());
            edit.commit();
            finish();
        } else {
            Toast.makeText(this, userBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

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
