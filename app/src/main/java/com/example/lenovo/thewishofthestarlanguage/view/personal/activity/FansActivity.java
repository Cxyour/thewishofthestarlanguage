package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IFansContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FansBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.FansPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.FansListAdapter;

import java.util.List;

public class FansActivity extends BaseActivity implements View.OnClickListener, IFansContract.IFansView {

    private ImageView fans_return;
    private ListView fans_list;
    private LinearLayout fans_nothing;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fans;
    }

    @Override
    protected void init() {
        fans_return = findViewById(R.id.fans_return);
        fans_list = findViewById(R.id.fans_list);
        fans_nothing = findViewById(R.id.fans_nothing);
        fans_return.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        SharedPreferences user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        FansPresenterImp fansPresenterImp = new FansPresenterImp(this);
        fansPresenterImp.loadFansBean(user.getInt("user_id",0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fans_return:
                finish();
                break;
        }
    }

    @Override
    public void showFansBean(List<FansBean.DataBean.ListBean> listBeans) {
        if (listBeans.size() == 0) {
            fans_nothing.setVisibility(View.VISIBLE);
            fans_list.setVisibility(View.GONE);
        } else {
            fans_nothing.setVisibility(View.GONE);
            fans_list.setVisibility(View.VISIBLE);
            FansListAdapter fansListAdapter = new FansListAdapter(listBeans);
            fans_list.setAdapter(fansListAdapter);
        }
    }

}
