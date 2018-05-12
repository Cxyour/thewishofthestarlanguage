package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IMyCollectionContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.CollectionBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MyCollectionPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;

import java.util.List;

public class EavesdroppingHomeworkFragment extends BaseFragment implements IMyCollectionContract.IMyCollectionView {

    private LinearLayout eaves_droppong_fragment_nothing;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;
    private MyCollectionPresenterImp myCollectionPresenterImp;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_eavesdropping_homework;
    }

    @Override
    protected void init(View view) {
        eaves_droppong_fragment_nothing = view.findViewById(R.id.eaves_droppong_fragment_nothing);
    }

    @Override
    protected void loadData() {
        user = getContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        myCollectionPresenterImp = new MyCollectionPresenterImp(this);
        myCollectionPresenterImp.loadMyCollectionData(user.getInt("user_id", 0), 3);
    }


    @Override
    public void showMyCollectionMessage(List<CollectionBean.DataBean.ListBean> listBeans) {

    }
}
