package com.example.lenovo.thewishofthestarlanguage.view.treasure.fragment;

import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.TreasureContact;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSure;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTu;
import com.example.lenovo.thewishofthestarlanguage.presenter.TreaSurePresenter;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.recker.flybanner.FlyBanner;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TreasureFragment extends BaseFragment implements TreasureContact.view {


    private PullLoadMoreRecyclerView treasure_recycle;
    private TreaSurePresenter treaSurePresenter;
    private FlyBanner treasure_fly;
    private String mobileImgUrl;
    private ArrayList<String> title=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_treasure;
    }

    @Override
    protected void init(View view) {
        treasure_recycle = view.findViewById(R.id.treasure_recycle);
        treasure_recycle.setLinearLayout();
        treasure_fly=view.findViewById(R.id.treasure_fly);

        TreaSurePresenter treaSurePresenter = new TreaSurePresenter(this);
        treaSurePresenter.loadLunbotu();
        treaSurePresenter.loadTreSure();
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void showTreSure(TreaSure treaSure) {
        TreaSure.DataBean data = treaSure.getData();
        title.add("智能筛选");
        title.add("赞数最多");
        title.add("最新评论");
        List<TreaSure.DataBean.ArtcircleCategoriesBean> artcircleCategories = data.getArtcircleCategories();
        for (TreaSure.DataBean.ArtcircleCategoriesBean artcircleCategory : artcircleCategories) {
            String name = artcircleCategory.getName();
            title.add(name);
        }


    }

    @Override
    public void showLunbotu(TreaSureLunBoTu treaSureLunBoTu) {
        ArrayList<String> imgurl = new ArrayList<>();
        List<TreaSureLunBoTu.DataBean.ListBean> list = treaSureLunBoTu.getData().getList();
        for (TreaSureLunBoTu.DataBean.ListBean listBean : list) {
            String mobileImgUrl = listBean.getMobileImgUrl();
            imgurl.add(mobileImgUrl);
        }
        treasure_fly.setImagesUrl(imgurl);
    }


}
