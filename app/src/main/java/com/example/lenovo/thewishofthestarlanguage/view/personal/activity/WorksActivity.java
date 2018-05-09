package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class WorksActivity extends BaseActivity implements View.OnClickListener {

    private ImageView works_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_works;
    }

    @Override
    protected void init() {
        works_return = findViewById(R.id.works_return);
        works_return.setOnClickListener(this);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.works_return:
                finish();
                break;
        }
    }
}
