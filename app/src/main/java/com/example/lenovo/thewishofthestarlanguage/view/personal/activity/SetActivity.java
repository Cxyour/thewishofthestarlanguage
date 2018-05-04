package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class SetActivity extends BaseActivity {

    private ImageView set_close;
    private ImageView set_go_change_phone;
    private TextView set_change_phone_text;
    private TextView set_phone_number;
    private ImageView set_go_change_id;
    private TextView set_change_id_text;
    private ImageView set_go_change_pass;
    private TextView set_change_pass_text;
    private ImageView set_go_change_catch;
    private TextView set_change_catch_text;
    private ImageView set_go_about_UnivStar;
    private ImageView set_go_close_login;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void init() {
        set_close = (ImageView) findViewById(R.id.set_close);
        set_go_change_phone = (ImageView) findViewById(R.id.set_go_change_phone);
        set_change_phone_text = (TextView) findViewById(R.id.set_change_phone_text);
        set_phone_number = (TextView) findViewById(R.id.set_phone_number);
        set_go_change_id = (ImageView) findViewById(R.id.set_go_change_id);
        set_change_id_text = (TextView) findViewById(R.id.set_change_id_text);
        set_go_change_pass = (ImageView) findViewById(R.id.set_go_change_pass);
        set_change_pass_text = (TextView) findViewById(R.id.set_change_pass_text);
        set_go_change_catch = (ImageView) findViewById(R.id.set_go_change_catch);
        set_change_catch_text = (TextView) findViewById(R.id.set_change_catch_text);
        set_go_about_UnivStar = (ImageView) findViewById(R.id.set_go_about_UnivStar);
        set_go_close_login = (ImageView) findViewById(R.id.set_go_close_login);
    }

    @Override
    protected void loadData() {

    }

}
