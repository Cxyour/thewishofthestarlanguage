package com.example.lenovo.thewishofthestarlanguage.view.personal.activity.myloves;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class PostActivity extends BaseActivity implements View.OnClickListener {

    private ImageView post_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post;
    }

    @Override
    protected void init() {
        post_return = findViewById(R.id.post_return);
        post_return.setOnClickListener(this);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_return:
                finish();
                break;
        }
    }
}
