package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IChangePasswordContract;
import com.example.lenovo.thewishofthestarlanguage.contact.IRegisterContract;
import com.example.lenovo.thewishofthestarlanguage.presenter.ChangePasswordPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.presenter.RegisterPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener, IRegisterContract.IRegisterView, IChangePasswordContract.IChangePasswordView {

    private ImageView change_pass_return;
    private TextView change_pass_phone;
    private EditText change_pass_code;
    private TextView change_pass_getCode;
    private Button change_pass_next;
    private String mobile;
    private RegisterPresenterImp registerPresenter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 3) {
                int i = (int) msg.obj;
                change_pass_getCode.setText(i + "");
                if (i == 0) {
                    change_pass_getCode.setText("获取验证码");
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
    private ChangePasswordPresenterImp changePasswordPresenterImp;
    private int tag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void init() {
        change_pass_return = (ImageView) findViewById(R.id.change_pass_return);
        change_pass_phone = (TextView) findViewById(R.id.change_pass_phone);
        change_pass_code = (EditText) findViewById(R.id.change_pass_code);
        change_pass_getCode = (TextView) findViewById(R.id.change_pass_getCode);
        change_pass_next = (Button) findViewById(R.id.change_pass_next);

        change_pass_return.setOnClickListener(this);
        change_pass_getCode.setOnClickListener(this);
        change_pass_next.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        change_pass_phone.setText(mobile);
        tag = intent.getIntExtra("tag", 0);
        registerPresenter = new RegisterPresenterImp(this);
        changePasswordPresenterImp = new ChangePasswordPresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_pass_return:
                finish();
                break;
            case R.id.change_pass_getCode:
                if (!change_pass_getCode.getText().equals("获取验证码"))
                    return;
                if (!registerPresenter.isUserName(mobile))
                    return;
                registerPresenter.loadPhoneMsg(mobile);
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
            case R.id.change_pass_next:
                if (tag == 1) {
                    changePasswordPresenterImp.loadCodeMessage(mobile, change_pass_code.getText().toString().trim());
                    Intent intent = new Intent(this, ChangeMobileActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    changePasswordPresenterImp.loadCodeMessage(mobile, change_pass_code.getText().toString().trim());
                    Intent intent = new Intent(this, ResetPassWordActivity.class);
                    intent.putExtra("mobile", mobile);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }

    @Override
    public void showPhoneNumberMessage(String phoneNumberMessage) {

    }

    @Override
    public void showRegisterMsg(String string) {

    }

    @Override
    public void showFirst(String string) {

    }

    @Override
    public void showCodeMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
