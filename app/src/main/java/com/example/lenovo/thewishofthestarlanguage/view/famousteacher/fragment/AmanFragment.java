package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IMasterContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MasterPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.MasterAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmanFragment extends BaseFragment implements IMasterContract.view{


    private RecyclerView aman_recycle;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_aman;
    }

    @Override
    protected void init(View view) {
        aman_recycle=view.findViewById(R.id.aman_recycle);
        aman_recycle.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    protected void loadData() {
        MasterPresenterImp masterPresenterImp = new MasterPresenterImp(this);
        masterPresenterImp.loadMasterBean(2);
    }

    @Override
    public void showMasterBean(MasterBean masterBean) {
        MasterBean.DataBean data = masterBean.getData();
        List<MasterBean.DataBean.ListBean> list = data.getList();
        MasterAdapter masterAdapter = new MasterAdapter(list);
        aman_recycle.setAdapter(masterAdapter);
    }
}
