package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ITheLatesRevieContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.TheLatesReviewPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.homework.adapter.MostEavedroppingAdapter;

import java.util.List;


public class TheLatestReviewFragment extends Fragment implements ITheLatesRevieContract.view{

    private RecyclerView thelate_recycle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_the_latest_review, container, false);
        thelate_recycle=inflate.findViewById(R.id.thelate_recycle);
        thelate_recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        TheLatesReviewPresenterImp theLatesReviewPresenter = new TheLatesReviewPresenterImp(this);
        theLatesReviewPresenter.loadMostEavesdeopp();
        return inflate;
    }


    @Override
    public void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean) {
        List<MostEavesdeoppBean.DataBean.ListBean> list = mostEavesdeoppBean.getData().getList();
        MostEavedroppingAdapter mostEavedroppingAdapter = new MostEavedroppingAdapter(list);
        thelate_recycle.setAdapter(mostEavedroppingAdapter);
    }
}
