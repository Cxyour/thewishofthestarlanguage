package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IntelligentScreeContarct;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.IntelligentScreePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.homework.adapter.MostEavedroppingAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntelligentScreeningFragment extends Fragment implements IntelligentScreeContarct.view{


    private RecyclerView intell_recycle;

    public IntelligentScreeningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_intelligent_screening, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        intell_recycle = (RecyclerView) inflate.findViewById(R.id.intell_recycle);
        intell_recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        IntelligentScreePresenterImp intelligentScreePresenter = new IntelligentScreePresenterImp(this);
        intelligentScreePresenter.loadMostEavesdeopp();
    }

    @Override
    public void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean) {
        List<MostEavesdeoppBean.DataBean.ListBean> list = mostEavesdeoppBean.getData().getList();
        MostEavedroppingAdapter mostEavedroppingAdapter = new MostEavedroppingAdapter(list);
        intell_recycle.setAdapter(mostEavedroppingAdapter);
    }
}
