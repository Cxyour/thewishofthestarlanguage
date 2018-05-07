package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IResetPassWordContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.ResetPassWordPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class ResetPassWordActivity extends BaseActivity implements View.OnClickListener, IResetPassWordContract.IResetPassWordView {

    private ImageView reset_password_close;
    private EditText reset_password_new_password;
    private EditText reset_password_new_password_again;
    private Button reset_password_finish;
    private String mobile;
    private ResetPassWordPresenterImp resetPassWordPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset;
    }

    @Override
    protected void init() {
        reset_password_close = (ImageView) findViewById(R.id.reset_password_close);
        reset_password_new_password = (EditText) findViewById(R.id.reset_password_new_password);
        reset_password_new_password_again = (EditText) findViewById(R.id.reset_password_new_password_again);
        reset_password_finish = (Button) findViewById(R.id.reset_password_finish);

        reset_password_finish.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra(Constant.User_mobile);
        resetPassWordPresenter = new ResetPassWordPresenterImp(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_password_finish:
                if (!resetPassWordPresenter.isPassWordSame(reset_password_new_password.getText().toString().trim(), reset_password_new_password_again.getText().toString().trim()))
                    return;
                resetPassWordPresenter.resetPassWord(mobile, reset_password_new_password.getText().toString().trim(), reset_password_new_password_again.getText().toString().trim());


                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showToastMessage(String string) {
        if (string != null) {
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showResetMessage(UserBean userBean) {
        SharedPreferences user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putString(Constant.User_mobile, userBean.getData().getMobile());
        edit.putString(Constant.User_name, userBean.getData().getNickname());
        edit.putString(Constant.User_icon, userBean.getData().getPhoto());
        edit.putInt(Constant.UserId, userBean.getData().getId());
        edit.commit();
    }
}
