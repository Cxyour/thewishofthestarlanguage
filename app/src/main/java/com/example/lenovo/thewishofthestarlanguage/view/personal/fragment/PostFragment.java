package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IPostContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PostBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.PostPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.PostListAdapter;

import java.util.List;

public class PostFragment extends BaseFragment implements IPostContract.IPostView {

    private ListView post_fragment_list;
    private LinearLayout post_fragment_nothing;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post;
    }

    @Override
    protected void init(View view) {
        post_fragment_list = view.findViewById(R.id.post_fragment_list);
        post_fragment_nothing = view.findViewById(R.id.post_fragment_nothing);
    }

    @Override
    protected void loadData() {
        user = getContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        PostPresenterImp postPresenterImp = new PostPresenterImp(this);
        postPresenterImp.loadPostBean(user.getInt("user_id",0));
    }


    @Override
    public void showPostBean(List<PostBean.DataBean.ArtcircleListBean.ListBean> artcircleListBeans) {
        if (artcircleListBeans.size() == 0) {
            post_fragment_nothing.setVisibility(View.VISIBLE);
            post_fragment_list.setVisibility(View.GONE);
        } else {
            post_fragment_nothing.setVisibility(View.GONE);
            post_fragment_list.setVisibility(View.VISIBLE);
            PostListAdapter postListAdapter = new PostListAdapter(artcircleListBeans);
            post_fragment_list.setAdapter(postListAdapter);
        }
    }

}
