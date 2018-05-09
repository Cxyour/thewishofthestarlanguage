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


public class AllFragment extends BaseFragment implements IMyOrderContract.MyOrderView {

    private SharedPreferences preferences;
    private MyOrderPresenterImp myOrderPresenterImp;
    private ListView all_list;
    private LinearLayout all_nothing;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_order;
    }

    @Override
    protected void init(View view) {
        all_list = view.findViewById(R.id.all_list);
        all_nothing = view.findViewById(R.id.all_nothing);
    }

    @Override
    protected void loadData() {
        preferences = getActivity().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        myOrderPresenterImp = new MyOrderPresenterImp(this);
        myOrderPresenterImp.getMyOrder(preferences.getInt("user_id", 0), -1);
    }

    @Override
    public void showMyOrder(List<MyOrderBean.DataBean.ListBean> list) {
        if (list.size() == 0) {
            all_nothing.setVisibility(View.VISIBLE);
            all_list.setVisibility(View.GONE);
        } else {
            all_nothing.setVisibility(View.GONE);
            all_list.setVisibility(View.VISIBLE);
            OrderAdapter orderAdapter = new OrderAdapter(list);
            all_list.setAdapter(orderAdapter);
        }
    }

}
