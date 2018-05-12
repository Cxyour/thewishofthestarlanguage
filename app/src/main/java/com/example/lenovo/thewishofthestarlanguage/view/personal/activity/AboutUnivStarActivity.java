package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IAboutUnivStarContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.AboutUnivStarBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.AboutUnivStarPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class AboutUnivStarActivity extends BaseActivity implements View.OnClickListener, IAboutUnivStarContract.IAboutUnivStarView {

    private ImageView about_UnivStar_return;
    private RelativeLayout about_UnivStar_message;
    private TextView about_UnivStar_version_code;
    private RelativeLayout about_UnivStar_version;
    private AboutUnivStarPresenterImp aboutUnivStarPresenterImp;
    private ImageView about_UnivStar_content_img;
    private Intent intent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_univ_star;
    }

    @Override
    protected void init() {
        about_UnivStar_return = (ImageView) findViewById(R.id.about_UnivStar_return);
        about_UnivStar_message = (RelativeLayout) findViewById(R.id.about_UnivStar_message);
        about_UnivStar_version_code = (TextView) findViewById(R.id.about_UnivStar_version_code);
        about_UnivStar_version = (RelativeLayout) findViewById(R.id.about_UnivStar_version);
        about_UnivStar_content_img = findViewById(R.id.about_UnivStar_content_img);

        about_UnivStar_return.setOnClickListener(this);
        about_UnivStar_message.setOnClickListener(this);
        about_UnivStar_version.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        aboutUnivStarPresenterImp = new AboutUnivStarPresenterImp(this);
        aboutUnivStarPresenterImp.loadAboutUnivStarMessage();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_UnivStar_return:
                finish();
                break;
            case R.id.about_UnivStar_message:
                intent = new Intent(this, UnivStarIntroduceActivity.class);
                startActivity(intent);
                break;
            case R.id.about_UnivStar_version:

                break;
        }
    }

    @Override
    public void showAboutUnivStarMessage(AboutUnivStarBean aboutUnivStarBean) {

    }
}
