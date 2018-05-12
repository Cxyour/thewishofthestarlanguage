package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.http.DataCleanManager;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class SetActivity extends BaseActivity implements View.OnClickListener {


    private TextView set_phone_number;
    private RelativeLayout set_change_phone;
    private RelativeLayout set_change_id;
    private RelativeLayout set_change_pass;
    private TextView set_close_catch;
    private RelativeLayout set_about_UnivStar;
    private RelativeLayout set_exit_login;
    private ImageView set_close;
    private Intent intent;
    private String mobile;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void init() {
        set_phone_number = (TextView) findViewById(R.id.set_phone_number);
        set_change_phone = (RelativeLayout) findViewById(R.id.set_change_phone);
        set_change_id = (RelativeLayout) findViewById(R.id.set_change_id);
        set_change_pass = (RelativeLayout) findViewById(R.id.set_change_pass);
        set_close_catch = (TextView) findViewById(R.id.set_close_catch);
        set_about_UnivStar = (RelativeLayout) findViewById(R.id.set_about_UnivStar);
        set_exit_login = (RelativeLayout) findViewById(R.id.set_exit_login);
        set_close = (ImageView) findViewById(R.id.set_close);

        set_change_phone.setOnClickListener(this);
        set_change_id.setOnClickListener(this);
        set_change_pass.setOnClickListener(this);
        set_close_catch.setOnClickListener(this);
        set_about_UnivStar.setOnClickListener(this);
        set_exit_login.setOnClickListener(this);
        set_close.setOnClickListener(this);
        try {
            String totalCacheSize = DataCleanManager.getTotalCacheSize(this);
            set_close_catch.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        set_close_catch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataCleanManager.clearAllCache(SetActivity.this);
                String totalCacheSize = null;
                try {
                    totalCacheSize = DataCleanManager.getTotalCacheSize(SetActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                set_close_catch.setText(totalCacheSize);
            }
        });
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        set_phone_number.setText(mobile);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_change_phone:
                intent = new Intent(this, ChangePasswordActivity.class);
                intent.putExtra("mobile", mobile);
                intent.putExtra("tag", 1);
                startActivity(intent);
                finish();
                break;

            case R.id.set_change_id:
                break;

            case R.id.set_change_pass:
                intent = new Intent(this, ChangePasswordActivity.class);
                intent.putExtra("mobile", mobile);
                intent.putExtra("tag", 2);
                startActivity(intent);
                finish();
                break;
            case R.id.set_close_catch:

                break;
            case R.id.set_about_UnivStar:
                intent = new Intent(this, AboutUnivStarActivity.class);
                startActivity(intent);
                break;
            case R.id.set_exit_login:
                SharedPreferences sharedPreferences = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("isLogin", false);
                edit.commit();
                finish();
                break;
            case R.id.set_close:
                finish();
                break;

        }
    }
}
