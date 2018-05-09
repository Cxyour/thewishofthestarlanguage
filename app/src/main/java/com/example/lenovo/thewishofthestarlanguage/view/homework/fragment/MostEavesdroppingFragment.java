package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;


import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class MostEavesdroppingFragment extends BaseFragment implements IMostEaveContract.view{


    private RecyclerView most_recycle;
    private MostEavePresenterImp mostEavePresenter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_most_eavesdropping;
    }

    @Override
    protected void init(View view) {
        most_recycle = view.findViewById(R.id.most_recycle);
        most_recycle.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void loadData() {
        mostEavePresenter = new MostEavePresenterImp(this);
        mostEavePresenter.loadMostEavesdeopp(1);
    }



    @Override
    public void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean) {

        List<MostEavesdeoppBean.DataBean.ListBean> list = mostEavesdeoppBean.getData().getList();
        MostEavedroppingAdapter mostEavedroppingAdapter = new MostEavedroppingAdapter(list,mostEavePresenter);
        most_recycle.setAdapter(mostEavedroppingAdapter);
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
