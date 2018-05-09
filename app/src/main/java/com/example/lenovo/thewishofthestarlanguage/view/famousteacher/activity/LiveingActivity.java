package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.LiveIngContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LiveDetailsBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LivePurchaseBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.LiveIngPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.LiveIngAdapter;

import java.util.List;

public class LiveingActivity extends BaseActivity implements View.OnClickListener,LiveIngContract.view {

    private TextView livinglist_aty_title_cancle;
    private RelativeLayout livinglist_aty_title_group;
    private TextView livinglist_aty_level1_tv;
    private TextView livinglist_aty_level1_line;
    private RelativeLayout livinglist_aty_level1;
    private TextView livinglist_aty_level2_tv;
    private TextView livinglist_aty_level2_line;
    private RelativeLayout livinglist_aty_level2;
    private RecyclerView livinglist_aty_recyclerview;
    private RelativeLayout livinglist_aty_recyclerview_empty;
    private Button livinglist_aty_recyclerview_fault_btn;
    private RelativeLayout livinglist_aty_recyclerview_fault;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_liveing;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadData() {
        LiveIngPresenterImp liveIngPresenterImp = new LiveIngPresenterImp(this);
        liveIngPresenterImp.loadLiveBean("讲堂");
    }

    private void initView() {
        livinglist_aty_title_cancle = (TextView) findViewById(R.id.livinglist_aty_title_cancle);
        livinglist_aty_title_group = (RelativeLayout) findViewById(R.id.livinglist_aty_title_group);
        livinglist_aty_level1_tv = (TextView) findViewById(R.id.livinglist_aty_level1_tv);
        livinglist_aty_level1_line = (TextView) findViewById(R.id.livinglist_aty_level1_line);
        livinglist_aty_level1 = (RelativeLayout) findViewById(R.id.livinglist_aty_level1);
        livinglist_aty_level2_tv = (TextView) findViewById(R.id.livinglist_aty_level2_tv);
        livinglist_aty_level2_line = (TextView) findViewById(R.id.livinglist_aty_level2_line);
        livinglist_aty_level2 = (RelativeLayout) findViewById(R.id.livinglist_aty_level2);
        livinglist_aty_recyclerview = (RecyclerView) findViewById(R.id.livinglist_aty_recyclerview);
        livinglist_aty_recyclerview_empty = (RelativeLayout) findViewById(R.id.livinglist_aty_recyclerview_empty);
        livinglist_aty_recyclerview_fault_btn = (Button) findViewById(R.id.livinglist_aty_recyclerview_fault_btn);
        livinglist_aty_recyclerview_fault = (RelativeLayout) findViewById(R.id.livinglist_aty_recyclerview_fault);
        livinglist_aty_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        livinglist_aty_recyclerview_fault_btn.setOnClickListener(this);
        livinglist_aty_level1.setOnClickListener(this);
        livinglist_aty_level2.setOnClickListener(this);
        livinglist_aty_title_cancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.livinglist_aty_recyclerview_fault_btn:

                break;
            case R.id.livinglist_aty_level1:
                livinglist_aty_recyclerview.setVisibility(View.VISIBLE);
                livinglist_aty_recyclerview_empty.setVisibility(View.GONE);
                break;
            case R.id.livinglist_aty_level2:
                livinglist_aty_recyclerview.setVisibility(View.GONE);
                livinglist_aty_recyclerview_empty.setVisibility(View.VISIBLE);
                break;
            case  R.id.livinglist_aty_title_cancle:
                finish();
                break;
        }
    }

    @Override
    public void showLiveBean(LiveDetailsBean liveDetailsBean) {
        List<LiveDetailsBean.DataBean.ListBean> list = liveDetailsBean.getData().getList();
        LiveIngAdapter liveIngAdapter = new LiveIngAdapter(list);
        livinglist_aty_recyclerview.setAdapter(liveIngAdapter);
    }

    @Override
    public void showLivePurchaseBean(LivePurchaseBean livePurchaseBean) {

    }

    @Override
    public void showGoodBean(GoodOnClickBean goodOnClickBean) {

    }

    @Override
    public void showCancelthePraise(GoodOnClickBean goodOnClickBean) {

    }
}
