package com.example.lenovo.thewishofthestarlanguage.view.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class MessageActivity extends BaseActivity implements View.OnClickListener {

    private ImageView message_return;
    private TextView message_order_time;
    private TextView message_order_remind;
    private TextView message_fabulous_time;
    private TextView message_fabulous_remind;
    private TextView message_talk_time;
    private TextView message_talk_remind;
    private TextView message_job_time;
    private TextView message_job_remind;
    private Button message_official_btn;
    private TextView message_official_time;
    private TextView message_official_remind;
    private TextView message_attention_time;
    private TextView message_attention_remind;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void init() {
        message_return = (ImageView) findViewById(R.id.message_return);
        message_order_time = (TextView) findViewById(R.id.message_order_time);
        message_order_remind = (TextView) findViewById(R.id.message_order_remind);
        message_fabulous_time = (TextView) findViewById(R.id.message_fabulous_time);
        message_fabulous_remind = (TextView) findViewById(R.id.message_fabulous_remind);
        message_talk_time = (TextView) findViewById(R.id.message_talk_time);
        message_talk_remind = (TextView) findViewById(R.id.message_talk_remind);
        message_job_time = (TextView) findViewById(R.id.message_job_time);
        message_job_remind = (TextView) findViewById(R.id.message_job_remind);
        message_official_btn = (Button) findViewById(R.id.message_official_btn);
        message_official_time = (TextView) findViewById(R.id.message_official_time);
        message_official_remind = (TextView) findViewById(R.id.message_official_remind);
        message_attention_time = (TextView) findViewById(R.id.message_attention_time);
        message_attention_remind = (TextView) findViewById(R.id.message_attention_remind);

        message_return.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_return:
                finish();
                break;
        }
    }
}
