package com.example.lenovo.thewishofthestarlanguage.view.personal.activity.myloves;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class FansActivity extends BaseActivity implements View.OnClickListener {

    private ImageView fans_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fans;
    }

    @Override
    protected void init() {
        fans_return = findViewById(R.id.fans_return);
        fans_return.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fans_return:
                finish();
                break;
        }
    }
}
