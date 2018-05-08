package com.example.lenovo.thewishofthestarlanguage.view.personal.activity.mymessage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class ChangeNickNameActivity extends BaseActivity implements View.OnClickListener {

    private ImageView change_nickname_return;
    private Button change_nickname_save;
    private EditText change_nickname_editText;

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
        change_nickname_editText.setText(getIntent().getStringExtra("nickname"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_nickname_save:
                Intent intent = new Intent();
                intent.putExtra("newNickName", change_nickname_editText.getText().toString().trim());
                setResult(2, intent);
                finish();
                break;
            case R.id.change_nickname_return:
                finish();
                break;
        }
    }

}
