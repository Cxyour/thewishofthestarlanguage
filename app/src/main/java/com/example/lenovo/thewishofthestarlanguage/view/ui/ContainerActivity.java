package com.example.lenovo.thewishofthestarlanguage.view.ui;

import android.app.FragmentManager;
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


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        home_master_btn = (ImageView) findViewById(R.id.home_master_btn);
        home_master_tv = (TextView) findViewById(R.id.home_master_tv);
        home_master_tab = (RelativeLayout) findViewById(R.id.home_master_tab);
        home_work_btn = (ImageView) findViewById(R.id.home_work_btn);
        home_work_tv = (TextView) findViewById(R.id.home_work_tv);
        home_work_tab = (RelativeLayout) findViewById(R.id.home_work_tab);
        home_valuable_btn = (ImageView) findViewById(R.id.home_valuable_btn);
        home_valuable_tv = (TextView) findViewById(R.id.home_valuable_tv);
        home_valuable_tab = (RelativeLayout) findViewById(R.id.home_valuable_tab);
        home_notice_btn = (ImageView) findViewById(R.id.home_notice_btn);
        home_notice_tv = (TextView) findViewById(R.id.home_notice_tv);
        home_notice_tab = (RelativeLayout) findViewById(R.id.home_notice_tab);
        home_myself_btn = (ImageView) findViewById(R.id.home_myself_btn);
        home_myself_tv = (TextView) findViewById(R.id.home_myself_tv);
        home_myself_tab = (RelativeLayout) findViewById(R.id.home_myself_tab);
        home_bottom_layout = (LinearLayout) findViewById(R.id.home_bottom_layout);

        home_master_tab.setOnClickListener(this);
        home_myself_tab.setOnClickListener(this);
        home_work_tab.setOnClickListener(this);
        home_valuable_tab.setOnClickListener(this);
        home_notice_tab.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        setContentView(R.id.home_lay,FamousTeacherFragment.class,null);
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
                setContentView(R.id.home_lay,HomeWorkFragment.class,null);
                setContentView(R.id.home_lay,FamousTeacherFragment.class,null);
                //名师
                break;
            case R.id.home_work_tab:
                //作业
                setContentView(R.id.home_lay,HomeWorkFragment.class,null);
                break;
            case R.id.home_valuable_tab:
                //宝典
                setContentView(R.id.home_lay,TreasureFragment.class,null);
                break;
            case R.id.home_notice_tab:
                //预告
                setContentView(R.id.home_lay,PreviewFragment.class,null);
                break;
            case R.id.home_myself_tab:
                setContentView(R.id.home_lay,PersonalFragment.class,null);
                //我的
                break;
        }
    }


}
