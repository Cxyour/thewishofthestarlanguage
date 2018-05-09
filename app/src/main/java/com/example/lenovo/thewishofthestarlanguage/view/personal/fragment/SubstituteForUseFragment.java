package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IMyOrderContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyOrderBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MyOrderPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.OrderAdapter;

import java.util.List;


public class SubstituteForUseFragment extends BaseFragment implements IMyOrderContract.MyOrderView {

    private SharedPreferences preferences;
    private MyOrderPresenterImp myOrderPresenterImp;
    private ListView substitute_for_use_list;
    private LinearLayout substitute_for_use_nothing;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_substitute_for_use;
    }

    @Override
    protected void init(View view) {
        substitute_for_use_list = view.findViewById(R.id.substitute_for_use_list);
        substitute_for_use_nothing = view.findViewById(R.id.substitute_for_use_nothing);
    }

    @Override
    protected void loadData() {
        preferences = getActivity().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        myOrderPresenterImp = new MyOrderPresenterImp(this);
        myOrderPresenterImp.getMyOrder(preferences.getInt("user_id", 0), 1);
    }

    @Override
    public void showMyOrder(List<MyOrderBean.DataBean.ListBean> list) {
        if (list.size() == 0) {
            substitute_for_use_nothing.setVisibility(View.VISIBLE);
            substitute_for_use_list.setVisibility(View.GONE);
        } else {
            substitute_for_use_nothing.setVisibility(View.GONE);
            substitute_for_use_list.setVisibility(View.VISIBLE);
            OrderAdapter orderAdapter = new OrderAdapter(list);
            substitute_for_use_list.setAdapter(orderAdapter);
        }
    }

}
