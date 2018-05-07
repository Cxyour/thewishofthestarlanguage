package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.MostEaveContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MostEavePresenter;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.homework.adapter.MostEavedroppingAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostEavesdroppingFragment extends BaseFragment implements MostEaveContract.view{


    private PullLoadMoreRecyclerView most_recycle;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_most_eavesdropping;
    }

    @Override
    protected void init(View view) {
        most_recycle = (PullLoadMoreRecyclerView) view.findViewById(R.id.most_recycle);
        most_recycle.setLinearLayout();
        MostEavePresenter mostEavePresenter = new MostEavePresenter(this);
        mostEavePresenter.loadMostEavesdeopp();
    }

    @Override
    protected void loadData() {

    }



    @Override
    public void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean) {
        List<MostEavesdeoppBean.DataBean.ListBean> list = mostEavesdeoppBean.getData().getList();
        MostEavedroppingAdapter mostEavedroppingAdapter = new MostEavedroppingAdapter(list);
        most_recycle.setAdapter(mostEavedroppingAdapter);
    }
}
