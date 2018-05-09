package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.MostEaveContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MostEavePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.homework.adapter.MostEavedroppingAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntelligentScreeningFragment extends BaseFragment implements MostEaveContract.view{


    private RecyclerView intell_recycle;
    private MostEavePresenterImp mostEavePresenterImp;

    public IntelligentScreeningFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_intelligent_screening;
    }

    @Override
    protected void init(View view) {
        initView(view);
    }

    @Override
    protected void loadData() {

    }

    private void initView(View inflate) {
        intell_recycle = (RecyclerView) inflate.findViewById(R.id.intell_recycle);
        intell_recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        mostEavePresenterImp = new MostEavePresenterImp(this);
        mostEavePresenterImp.loadMostEavesdeopp(0);
}

    @Override
    public void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean) {
        List<MostEavesdeoppBean.DataBean.ListBean> list = mostEavesdeoppBean.getData().getList();
        MostEavedroppingAdapter mostEavedroppingAdapter = new MostEavedroppingAdapter(list,mostEavePresenterImp);
        intell_recycle.setAdapter(mostEavedroppingAdapter);
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
