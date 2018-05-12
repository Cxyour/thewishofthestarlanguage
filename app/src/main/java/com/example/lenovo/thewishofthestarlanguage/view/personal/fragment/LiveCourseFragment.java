package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IMyCollectionContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.CollectionBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MyCollectionPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.LiveCourseListAdapter;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.PostListAdapter;

import java.util.List;

public class LiveCourseFragment extends BaseFragment implements IMyCollectionContract.IMyCollectionView {

    private ListView live_course_fragment_list;
    private LinearLayout live_course_fragment_nothing;
    private SharedPreferences.Editor edit;
    private SharedPreferences user;
    private MyCollectionPresenterImp myCollectionPresenterImp;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_course;
    }

    @Override
    protected void init(View view) {
        live_course_fragment_list = view.findViewById(R.id.live_course_fragment_list);
        live_course_fragment_nothing = view.findViewById(R.id.live_course_fragment_nothing);
    }

    @Override
    protected void loadData() {
        user = getContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        myCollectionPresenterImp = new MyCollectionPresenterImp(this);
        myCollectionPresenterImp.loadMyCollectionData(user.getInt("user_id", 0), 1);
    }

    @Override
    public void showMyCollectionMessage(List<CollectionBean.DataBean.ListBean> listBeans) {
        if (listBeans.size() == 0) {
            live_course_fragment_nothing.setVisibility(View.VISIBLE);
            live_course_fragment_list.setVisibility(View.GONE);
        } else {
            live_course_fragment_nothing.setVisibility(View.GONE);
            live_course_fragment_list.setVisibility(View.VISIBLE);
            LiveCourseListAdapter liveCourseListAdapter = new LiveCourseListAdapter(listBeans);
            live_course_fragment_list.setAdapter(liveCourseListAdapter);
        }
    }
}
