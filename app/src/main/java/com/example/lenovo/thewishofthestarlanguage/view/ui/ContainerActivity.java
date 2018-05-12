package com.example.lenovo.thewishofthestarlanguage.view.ui;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment.FamousTeacherFragment;
import com.example.lenovo.thewishofthestarlanguage.view.homework.fragment.HomeWorkFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.PersonalFragment;
import com.example.lenovo.thewishofthestarlanguage.view.preview.fragment.PreviewFragment;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.fragment.TreasureFragment;

public class ContainerActivity extends BaseActivity implements View.OnClickListener {


    private RadioButton home_master_tab;

    private RadioButton home_work_tab;

    private RadioButton home_valuable_tab;

    private RadioButton home_notice_tab;

    private RadioButton home_myself_tab;
    private LinearLayout home_bottom_layout;
    private LinearLayout home_bo;
    private FragmentManager fragmentManager;
    private ImageView home_master_shape;
    private ImageView home_publish_valuable;
    private RelativeLayout home_title;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;
    private Intent intent;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {

        home_master_tab = findViewById(R.id.home_master_tab);

        home_work_tab = findViewById(R.id.home_work_tab);

        home_valuable_tab = findViewById(R.id.home_valuable_tab);

        home_notice_tab = findViewById(R.id.home_notice_tab);
        home_myself_tab = findViewById(R.id.home_myself_tab);
        home_bottom_layout = findViewById(R.id.home_bottom_layout);
        home_master_shape = findViewById(R.id.home_master_shape);
        home_publish_valuable = findViewById(R.id.home_publish_valuable);
        home_title = findViewById(R.id.home_title);

        home_master_tab.setOnClickListener(this);
        home_myself_tab.setOnClickListener(this);
        home_work_tab.setOnClickListener(this);
        home_valuable_tab.setOnClickListener(this);
        home_notice_tab.setOnClickListener(this);
        home_master_shape.setOnClickListener(this);
        home_publish_valuable.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        home_publish_valuable.setVisibility(View.GONE);
        setContentView(R.id.home_lay, FamousTeacherFragment.class, null);
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_master_tab:
                //名师
                home_title.setVisibility(View.VISIBLE);
                home_publish_valuable.setVisibility(View.GONE);
                setContentView(R.id.home_lay, HomeWorkFragment.class, null);
                setContentView(R.id.home_lay, FamousTeacherFragment.class, null);
                break;
            case R.id.home_work_tab:
                //作业
                home_title.setVisibility(View.VISIBLE);
                home_publish_valuable.setVisibility(View.GONE);
                setContentView(R.id.home_lay, HomeWorkFragment.class, null);
                break;
            case R.id.home_valuable_tab:
                //宝典

                home_title.setVisibility(View.VISIBLE);
                home_publish_valuable.setVisibility(View.VISIBLE);
                setContentView(R.id.home_lay, TreasureFragment.class, null);
                break;
            case R.id.home_notice_tab:
                //预告
                home_title.setVisibility(View.VISIBLE);
                home_publish_valuable.setVisibility(View.GONE);
                setContentView(R.id.home_lay, PreviewFragment.class, null);
                break;
            case R.id.home_myself_tab:
                //我的
                home_title.setVisibility(View.GONE);
                setContentView(R.id.home_lay, PersonalFragment.class, null);
                break;

            case R.id.home_master_shape:
                if (user.getBoolean("isLogin", false)) {
                    intent = new Intent(this, MessageActivity.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }

                break;

            case R.id.home_publish_valuable:

                break;
        }
    }

}
