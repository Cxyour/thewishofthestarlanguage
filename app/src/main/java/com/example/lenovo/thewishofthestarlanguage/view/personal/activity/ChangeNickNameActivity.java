package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IMessageChangeContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.presenter.MessageChangePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

public class ChangeNickNameActivity extends BaseActivity implements View.OnClickListener, IMessageChangeContract.IMessageChangeView {

    private ImageView change_nickname_return;
    private Button change_nickname_save;
    private EditText change_nickname_editText;
    private MessageChangePresenterImp messageChangePresenterImp;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_nick_name;
    }

    @Override
    protected void init() {
        change_nickname_return = (ImageView) findViewById(R.id.change_nickname_return);
        change_nickname_save = (Button) findViewById(R.id.change_nickname_save);
        change_nickname_editText = (EditText) findViewById(R.id.change_nickname_editText);

        change_nickname_return.setOnClickListener(this);
        change_nickname_save.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        change_nickname_editText.setText(getIntent().getStringExtra("nickname"));
        messageChangePresenterImp = new MessageChangePresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_nickname_save:
                Intent intent = new Intent();
                intent.putExtra("newNickName", change_nickname_editText.getText().toString().trim());
                Map<String, String> paramsMap = new HashMap<>();
                paramsMap.put("nickname", change_nickname_editText.getText().toString().trim());
                messageChangePresenterImp.messageChange(user.getInt("user_id", 0), paramsMap);
                setResult(2, intent);
                finish();
                break;
            case R.id.change_nickname_return:
                finish();
                break;
        }
    }

    @Override
    public void showMessageChangeMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
