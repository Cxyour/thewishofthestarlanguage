package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IRegisterContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.presenter.RegisterPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, IRegisterContract.IRegisterView {

    private TextView register_goto_weixin;
    private TextView register_goto_qq;
    private TextView register_goto_sina;
    private LinearLayout other_register;
    private EditText register_username;
    private EditText register_password;
    private Button register_close_password;
    private TextView register_checked_http;
    private Button register_register;
    private ImageView register_close;
    private RegisterPresenterImp registerPresenter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 3) {
                int i = (int) msg.obj;
                register_close_password.setText(i + "");
                if (i == 0) {
                    register_close_password.setText("获取验证码");
                    count = 60;
                    return;
                } else {
                    handler.postDelayed(runnable, 1000);
                }
            }
        }
    };
    private int count = 60;
    private Runnable runnable;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        register_goto_weixin = (TextView) findViewById(R.id.register_goto_weixin);
        register_goto_qq = (TextView) findViewById(R.id.register_goto_qq);
        register_goto_sina = (TextView) findViewById(R.id.register_goto_sina);
        other_register = (LinearLayout) findViewById(R.id.other_register);
        register_username = (EditText) findViewById(R.id.register_username);
        register_password = (EditText) findViewById(R.id.register_password);
        register_close_password = (Button) findViewById(R.id.register_close_password);
        register_checked_http = (TextView) findViewById(R.id.register_checked_http);
        register_register = (Button) findViewById(R.id.register_register);
        register_close = (ImageView) findViewById(R.id.register_close);
        register_close.setOnClickListener(this);
        register_close_password.setOnClickListener(this);
        register_register.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        registerPresenter = new RegisterPresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_close_password:
                if (!register_close_password.getText().equals("获取验证码"))
                    return;
                if (!registerPresenter.isUserName(register_username.getText().toString().trim()))
                    return;
                registerPresenter.loadPhoneMsg(register_username.getText().toString().trim());
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (count >= 0) {
                            Message message = handler.obtainMessage(3, count);
                            count--;
                            handler.sendMessage(message);
                        }
                    }
                };
                handler.postDelayed(runnable, 1000);
                break;
            case R.id.register_register:
                if (!registerPresenter.isUserName(register_username.getText().toString().trim()))
                    return;
                registerPresenter.goToRegister(register_username.getText().toString(), register_password.getText().toString());
                SharedPreferences preferences = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = preferences.edit();
                edit.putString(Constant.User_mobile, register_username.getText().toString().trim());
                Intent intent = new Intent(this, PerfectInformationActivity.class);
                intent.putExtra("phone", register_username.getText().toString().trim());
                startActivity(intent);
                break;
            case R.id.register_close:
                finish();
                break;
        }
    }

    @Override
    public void showPhoneNumberMessage(String phoneNumberMessage) {
        if (phoneNumberMessage != null) {
            Toast.makeText(this, phoneNumberMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showRegisterMsg(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFirst(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
