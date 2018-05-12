package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.MasterHomeContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterHomeBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MoasterHomePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.MasterHomeAdapter;
import com.example.lenovo.thewishofthestarlanguage.view.ui.WorkWorkActivityActivity;

public class MasterDetailActivity extends BaseActivity implements MasterHomeContract.view {

    public View rootView;
    public RelativeLayout masterdetail_coachbtn;
    public RecyclerView masterdetail_recycle;
    public ImageView back;
    public ImageView masterdetail_aty_share;
    public RelativeLayout titlelan;
    private MoasterHomePresenterImp moasterHomePresenterImp;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_master_detail;
    }

    @Override
    protected void init() {
        this.masterdetail_coachbtn = (RelativeLayout) findViewById(R.id.masterdetail_coachbtn);
        this.masterdetail_recycle = (RecyclerView) findViewById(R.id.masterdetail_recycle);
        masterdetail_recycle.setLayoutManager(new LinearLayoutManager(this));
        this. back =(ImageView)findViewById(R.id.back);
        this.masterdetail_aty_share = findViewById(R.id.masterdetail_aty_share);
        this.titlelan = (RelativeLayout) findViewById(R.id.titlelan);
    }

    @Override
    protected void loadData() {
        moasterHomePresenterImp = new MoasterHomePresenterImp(this);
        Intent intent = getIntent();
        int teacherId = intent.getIntExtra("teacherId", 0);
        moasterHomePresenterImp.loadMasterHomeBean(teacherId);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        masterdetail_coachbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterDetailActivity.this, WorkWorkActivityActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void showMasterHomeBean(MasterHomeBean masterBean) {

        MasterHomeBean.DataBean user = masterBean.getData();
        MasterHomeAdapter masterHomeAdapter = new MasterHomeAdapter(user,moasterHomePresenterImp);
        masterdetail_recycle.setAdapter(masterHomeAdapter);

    }

    @Override
    public void showGoodBean(GoodOnClickBean goodOnClickBean) {
        Toast.makeText(this, "点赞"+goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCancelthePraise(GoodOnClickBean goodOnClickBean) {
        Toast.makeText(this, "取消"+goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
