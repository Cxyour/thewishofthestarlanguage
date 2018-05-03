package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class PerfectInformationActivity extends BaseActivity {


    private ImageView perfect_information_return;
    private ImageView perfect_information_album;
    private ImageView perfect_information_camera;
    private EditText perfect_information_name;
    private ImageView perfect_information_close_name;
    private RadioButton perfect_information_man;
    private RadioButton perfect_information_women;
    private RadioGroup perfect_information_rg;
    private EditText perfect_information_password;
    private ImageView perfect_information_close_password;
    private Button perfect_information_finish;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_perfect_information;
    }

    @Override
    protected void init() {
        perfect_information_return = findViewById(R.id.perfect_information_return);
        perfect_information_album = findViewById(R.id.perfect_information_album);
        perfect_information_camera = findViewById(R.id.perfect_information_camera);
        perfect_information_name = findViewById(R.id.perfect_information_name);
        perfect_information_close_name = findViewById(R.id.perfect_information_close_name);
        perfect_information_man = findViewById(R.id.perfect_information_man);
        perfect_information_women = findViewById(R.id.perfect_information_women);
        perfect_information_rg = findViewById(R.id.perfect_information_rg);
        perfect_information_password = findViewById(R.id.perfect_information_password);
        perfect_information_close_password = findViewById(R.id.perfect_information_close_password);
        perfect_information_finish = findViewById(R.id.perfect_information_finish);
    }

    @Override
    protected void loadData() {

    }

}
