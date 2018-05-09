package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IMostEaveContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MostEavePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.homework.adapter.MostEavedroppingAdapter;

import java.util.List;


public class TheLatestReviewFragment extends BaseFragment implements IMostEaveContract.view{

    private RecyclerView thelate_recycle;
    private MostEavePresenterImp mostEavePresenterImp;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_the_latest_review;
    }

    @Override
    protected void init(View inflate) {
        thelate_recycle=inflate.findViewById(R.id.thelate_recycle);
        thelate_recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        mostEavePresenterImp = new MostEavePresenterImp(this);
        mostEavePresenterImp.loadMostEavesdeopp(2);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean) {
        List<MostEavesdeoppBean.DataBean.ListBean> list = mostEavesdeoppBean.getData().getList();
        MostEavedroppingAdapter mostEavedroppingAdapter = new MostEavedroppingAdapter(list,mostEavePresenterImp);
        thelate_recycle.setAdapter(mostEavedroppingAdapter);
    }

    @Override
    public void showGoodBean(GoodOnClickBean goodOnClickBean) {
        Toast.makeText(getContext(), goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCancelthePraise(GoodOnClickBean goodOnClickBean) {
        Toast.makeText(getContext(), "取消"+goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
