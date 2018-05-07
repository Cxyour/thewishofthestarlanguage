package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IFindPassWordContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.presenter.FindPassWordPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class FindPassWordActivity extends BaseActivity implements View.OnClickListener, IFindPassWordContract.IFindPassWordView {

    private ImageView find_password_close;
    private EditText find_password_ed_phone_number;
    private EditText find_password_ed_phone_code;
    private TextView find_password_getPhoneCode;
    private Button find_password_goToNext;
    private FindPassWordPresenterImp findPassWordPresenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_find_pass_word;
    }

    @Override
    protected void init() {
        find_password_close = (ImageView) findViewById(R.id.find_password_close);
        find_password_ed_phone_number = (EditText) findViewById(R.id.find_password_ed_phone_number);
        find_password_ed_phone_code = (EditText) findViewById(R.id.find_password_ed_phone_code);
        find_password_getPhoneCode = (TextView) findViewById(R.id.find_password_getPhoneCode);
        find_password_goToNext = (Button) findViewById(R.id.find_password_goToNext);

        find_password_getPhoneCode.setOnClickListener(this);
        find_password_goToNext.setOnClickListener(this);
        find_password_close.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        findPassWordPresenter = new FindPassWordPresenterImp(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_password_goToNext:
                if (!findPassWordPresenter.isUserName(find_password_ed_phone_number.getText().toString().trim()))
                    return;
                findPassWordPresenter.goToResetPassWord(find_password_ed_phone_number.getText().toString().trim(), find_password_ed_phone_code.getText().toString().trim());
                Intent intent = new Intent(this, ResetPassWordActivity.class);
                intent.putExtra(Constant.User_mobile, find_password_ed_phone_number.getText().toString().trim());
                startActivity(intent);
                break;
            case R.id.find_password_getPhoneCode:
                findPassWordPresenter.loadPhoneMsg(find_password_ed_phone_number.getText().toString().trim());
                break;

            case R.id.find_password_close:
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
}
