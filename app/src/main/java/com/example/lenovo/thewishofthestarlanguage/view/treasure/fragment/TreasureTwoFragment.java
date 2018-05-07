package com.example.lenovo.thewishofthestarlanguage.view.treasure.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.TreasureContact;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTuBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.TreaSurePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.adapter.TreasureAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TreasureTwoFragment extends Fragment implements TreasureContact.view{


    private PullLoadMoreRecyclerView treasure_two_fly;
    private TreaSurePresenterImp treaSurePresenter;

    public TreasureTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_treasure_two, container, false);
        initView(inflate);
        treaSurePresenter = new TreaSurePresenterImp(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int id = arguments.getInt("id");
            if (id<3){
                treaSurePresenter.loadTreSure(id);
            }
        }

        return inflate;
    }

    private void initView(View inflate) {
        treasure_two_fly = (PullLoadMoreRecyclerView) inflate.findViewById(R.id.treasure_two_fly);
        treasure_two_fly.setLinearLayout();
        treasure_two_fly.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                treasure_two_fly.setPullLoadMoreCompleted();

          }

            @Override
            public void onLoadMore() {
                treasure_two_fly.setPullLoadMoreCompleted();
            }
        });
    }

    @Override
    public void showTreSure(TreaSureBean treaSure) {
        TreaSureBean.DataBean.ArtcircleListBean artcircleList = treaSure.getData().getArtcircleList();
        List<TreaSureBean.DataBean.ArtcircleListBean.ListBean> list = artcircleList.getList();
        TreasureAdapter treasureAdapter = new TreasureAdapter(list);
        treasure_two_fly.setAdapter(treasureAdapter);
    }

    @Override
    public void showLunbotu(TreaSureLunBoTuBean treaSureLunBoTu) {

    }
}
