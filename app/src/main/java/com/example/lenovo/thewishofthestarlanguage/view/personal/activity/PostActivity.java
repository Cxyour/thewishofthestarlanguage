package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IPostContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PostBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.PostPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.FansListAdapter;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.PostListAdapter;

import java.util.List;

public class PostActivity extends BaseActivity implements View.OnClickListener, IPostContract.IPostView {

    private ImageView post_return;
    private ListView post_list;
    private LinearLayout post_nothing;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post;
    }

    @Override
    protected void init() {
        post_return = findViewById(R.id.post_return);
        post_list = findViewById(R.id.post_list);
        post_nothing = findViewById(R.id.post_nothing);
        post_return.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        PostPresenterImp postPresenterImp = new PostPresenterImp(this);
        postPresenterImp.loadPostBean(user.getInt("user_id", 0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_return:
                finish();
                break;
        }
    }


    @Override
    public void showPostBean(List<PostBean.DataBean.ArtcircleListBean.ListBean> artcircleListBeans) {
        if (artcircleListBeans.size() == 0) {
            post_nothing.setVisibility(View.VISIBLE);
            post_list.setVisibility(View.GONE);
        } else {
            post_nothing.setVisibility(View.GONE);
            post_list.setVisibility(View.VISIBLE);
            PostListAdapter postListAdapter = new PostListAdapter(artcircleListBeans);
            post_list.setAdapter(postListAdapter);
        }
    }
}
