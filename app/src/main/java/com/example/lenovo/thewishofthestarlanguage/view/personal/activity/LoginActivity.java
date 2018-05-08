package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ILoginContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserSuccessBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.LoginPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginContract.ILoginView {

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
    private String loginstatus;

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
        login_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() != 0) {
                    login_close_username.setVisibility(View.VISIBLE);
                } else {
                    login_close_username.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        login_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() != 0) {
                    login_close_password.setVisibility(View.VISIBLE);
                } else {
                    login_close_password.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
    public void showLoginMessage(UserSuccessBean userSuccessBean) {
        Log.e("--========-", String.valueOf(userSuccessBean.getData().getSex()));
        if (userSuccessBean.getMessage().equals("成功")) {
            SharedPreferences user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = user.edit();
            edit.putBoolean("isLogin", true);
            edit.putString("mobile", userSuccessBean.getData().getMobile());
            edit.putString("nickname", userSuccessBean.getData().getNickname());
            edit.putString("photo", userSuccessBean.getData().getPhoto());
            edit.putInt("user_id", userSuccessBean.getData().getId());
            edit.putString("address", (String) userSuccessBean.getData().getAddress());
            edit.putLong("birthday", userSuccessBean.getData().getBirthday());
            edit.putInt("sex", userSuccessBean.getData().getSex());
            edit.commit();
            finish();
        } else {
            Toast.makeText(this, userSuccessBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}
