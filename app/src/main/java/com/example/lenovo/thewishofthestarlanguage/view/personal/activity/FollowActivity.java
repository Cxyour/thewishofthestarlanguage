package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IFollowContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FollowBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.FollowPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.FollowListAdapter;

import java.util.List;

public class FollowActivity extends BaseActivity implements View.OnClickListener, IFollowContract.IFollowView {

    private ImageView follow_return;
    private ListView follow_list;
    private LinearLayout follow_nothing;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_follow;
    }

    @Override
    protected void init() {
        follow_return = findViewById(R.id.follow_return);
        follow_list = findViewById(R.id.follow_list);
        follow_nothing = findViewById(R.id.follow_nothing);
        follow_return.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        SharedPreferences user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        FollowPresenterImp followPresenterImp = new FollowPresenterImp(this);
        followPresenterImp.loadFollowBean(user.getInt("user_id",0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follow_return:
                finish();
                break;
        }
    }

    @Override
    public void showFollowBean(List<FollowBean.DataBean.ListBean> listBeans) {
        if (listBeans.size() == 0) {
            follow_nothing.setVisibility(View.VISIBLE);
            follow_list.setVisibility(View.GONE);
        } else {
            follow_nothing.setVisibility(View.GONE);
            follow_list.setVisibility(View.VISIBLE);
            FollowListAdapter followListAdapter = new FollowListAdapter(listBeans);
            follow_list.setAdapter(followListAdapter);
        }
    }
}
