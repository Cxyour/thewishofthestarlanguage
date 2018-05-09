package com.example.lenovo.thewishofthestarlanguage.view.personal.activity.myorder.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.MyOrderContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyOrderBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MyOrderPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.myorder.adapter.OrderAdapter;

import java.util.List;


public class SubstituteForUseFragment extends BaseFragment implements MyOrderContract.MyOrderView {

    private SharedPreferences preferences;
    private MyOrderPresenterImp myOrderPresenterImp;
    private ListView substitute_for_use_list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_substitute_for_use;
    }

    @Override
    protected void init(View view) {
        substitute_for_use_list = view.findViewById(R.id.substitute_for_use_list);
    }

    @Override
    protected void loadData() {
        preferences = getActivity().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        myOrderPresenterImp = new MyOrderPresenterImp(this);
        myOrderPresenterImp.getMyOrder(preferences.getInt("user_id", 0), 1);
    }

    @Override
    public void showMyOrder(List<MyOrderBean.DataBean.ListBean> list) {
        OrderAdapter orderAdapter = new OrderAdapter(list);
        substitute_for_use_list.setAdapter(orderAdapter);
    }

}
