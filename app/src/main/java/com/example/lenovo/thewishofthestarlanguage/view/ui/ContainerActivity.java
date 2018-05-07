package com.example.lenovo.thewishofthestarlanguage.view.ui;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment.FamousTeacherFragment;
import com.example.lenovo.thewishofthestarlanguage.view.homework.fragment.HomeWorkFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.PersonalFragment;
import com.example.lenovo.thewishofthestarlanguage.view.preview.fragment.PreviewFragment;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.fragment.TreasureFragment;

public class ContainerActivity extends BaseActivity implements View.OnClickListener {

    private ImageView home_master_btn;
    private TextView home_master_tv;
    private RelativeLayout home_master_tab;
    private ImageView home_work_btn;
    private TextView home_work_tv;
    private RelativeLayout home_work_tab;
    private ImageView home_valuable_btn;
    private TextView home_valuable_tv;
    private RelativeLayout home_valuable_tab;
    private ImageView home_notice_btn;
    private TextView home_notice_tv;
    private RelativeLayout home_notice_tab;
    private ImageView home_myself_btn;
    private TextView home_myself_tv;
    private RelativeLayout home_myself_tab;
    private LinearLayout home_bottom_layout;

    private LinearLayout home_bo;
    private FragmentManager fragmentManager;
    private ImageView home_master_shape;
    private ImageView home_publish_valuable;
    private RelativeLayout home_title;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        home_master_btn = findViewById(R.id.home_master_btn);
        home_master_tv = findViewById(R.id.home_master_tv);
        home_master_tab = findViewById(R.id.home_master_tab);
        home_work_btn = findViewById(R.id.home_work_btn);
        home_work_tv = findViewById(R.id.home_work_tv);
        home_work_tab = findViewById(R.id.home_work_tab);
        home_valuable_btn = findViewById(R.id.home_valuable_btn);
        home_valuable_tv = findViewById(R.id.home_valuable_tv);
        home_valuable_tab = findViewById(R.id.home_valuable_tab);
        home_notice_btn = findViewById(R.id.home_notice_btn);
        home_notice_tv = findViewById(R.id.home_notice_tv);
        home_notice_tab = findViewById(R.id.home_notice_tab);
        home_myself_btn = findViewById(R.id.home_myself_btn);
        home_myself_tv = findViewById(R.id.home_myself_tv);
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
        setContentView(R.id.home_lay, FamousTeacherFragment.class, null);
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
                home_publish_valuable.setVisibility(View.GONE);
                setContentView(R.id.home_lay, HomeWorkFragment.class, null);
                setContentView(R.id.home_lay, FamousTeacherFragment.class, null);
                break;
            case R.id.home_work_tab:
                //作业
                home_publish_valuable.setVisibility(View.GONE);
                setContentView(R.id.home_lay, HomeWorkFragment.class, null);
                break;
            case R.id.home_valuable_tab:
                //宝典
                setContentView(R.id.home_lay, TreasureFragment.class, null);
                break;
            case R.id.home_notice_tab:
                //预告
                home_publish_valuable.setVisibility(View.GONE);
                setContentView(R.id.home_lay, PreviewFragment.class, null);
                break;
            case R.id.home_myself_tab:
                //我的
                home_title.setVisibility(View.GONE);
                setContentView(R.id.home_lay, PersonalFragment.class, null);
                break;

            case R.id.home_master_shape:
                break;

            case R.id.home_publish_valuable:
                break;
        }
    }

}
