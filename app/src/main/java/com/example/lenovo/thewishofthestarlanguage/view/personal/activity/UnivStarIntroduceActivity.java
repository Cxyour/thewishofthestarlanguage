package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class UnivStarIntroduceActivity extends BaseActivity implements View.OnClickListener {

    private ImageView UnivStar_introduce_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_univ_star_introduce;
    }

    @Override
    protected void init() {
        UnivStar_introduce_return = findViewById(R.id.UnivStar_introduce_return);
        UnivStar_introduce_return.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.UnivStar_introduce_return:
                finish();
                break;
        }
    }
}
