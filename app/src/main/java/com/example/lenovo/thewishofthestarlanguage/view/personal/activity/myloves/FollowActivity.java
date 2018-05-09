package com.example.lenovo.thewishofthestarlanguage.view.personal.activity.myloves;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class FollowActivity extends BaseActivity implements View.OnClickListener {

    private ImageView follow_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_follow;
    }

    @Override
    protected void init() {
        follow_return = findViewById(R.id.follow_return);
        follow_return.setOnClickListener(this);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follow_return:
                finish();
                break;
        }
    }
}
