package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.lenovo.thewishofthestarlanguage.contact.IChangeMobileContract;
import com.example.lenovo.thewishofthestarlanguage.contact.IRegisterContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.presenter.ChangeMobilePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.presenter.RegisterPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class ChangeMobileActivity extends BaseActivity implements View.OnClickListener, IChangeMobileContract.IChangeMobileView, IRegisterContract.IRegisterView {

    private ImageView change_mobile_return;
    private EditText change_mobile_new_mobile;
    private EditText change_mobile_code;
    private TextView change_mobile_get_code;
    private Button change_mobile_finish;
    private ChangeMobilePresenterImp changeMobilePresenterImp;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;
    private RegisterPresenterImp registerPresenter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 3) {
                int i = (int) msg.obj;
                change_mobile_get_code.setText(i + "");
                if (i == 0) {
                    change_mobile_get_code.setText("获取验证码");
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
        return R.layout.activity_change_mobile;
    }

    @Override
    protected void init() {
        change_mobile_return = (ImageView) findViewById(R.id.change_mobile_return);
        change_mobile_new_mobile = (EditText) findViewById(R.id.change_mobile_new_mobile);
        change_mobile_code = (EditText) findViewById(R.id.change_mobile_code);
        change_mobile_get_code = (TextView) findViewById(R.id.change_mobile_get_code);
        change_mobile_finish = (Button) findViewById(R.id.change_mobile_finish);

        change_mobile_return.setOnClickListener(this);
        change_mobile_get_code.setOnClickListener(this);
        change_mobile_finish.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        changeMobilePresenterImp = new ChangeMobilePresenterImp(this);
        registerPresenter = new RegisterPresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_mobile_return:
                finish();
                break;
            case R.id.change_mobile_get_code:
                if (!change_mobile_get_code.getText().equals("获取验证码"))
                    return;
                if (!registerPresenter.isUserName(change_mobile_new_mobile.getText().toString().trim()))
                    return;
                registerPresenter.loadPhoneMsg(change_mobile_new_mobile.getText().toString().trim());
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
            case R.id.change_mobile_finish:
                changeMobilePresenterImp.changeMobile(user.getInt("user_id", 0), change_mobile_new_mobile.getText().toString().trim(), change_mobile_code.getText().toString().trim());
                finish();
                break;
        }
    }

    @Override
    public void showChangeMobileMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
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
}
