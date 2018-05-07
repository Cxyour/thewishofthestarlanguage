package com.example.lenovo.thewishofthestarlanguage.view.treasure.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.TreasureContact;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTuBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.TreaSurePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.adapter.TreaFragmentAdapter;
import com.recker.flybanner.FlyBanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TreasureFragment extends BaseFragment implements TreasureContact.view {



    private TreaSurePresenterImp treaSurePresenter;
    private FlyBanner treasure_fly;

    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Fragment> mFragment = new ArrayList<>();
    private TabLayout tres_tabla;
    private ViewPager treasure_viewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_treasure;
    }

    @Override
    protected void init(View view) {


        treasure_fly = view.findViewById(R.id.treasure_fly);
       tres_tabla=view.findViewById(R.id.tres_tabla);
       treasure_viewpager=view.findViewById(R.id.treasure_viewpager);
        treaSurePresenter = new TreaSurePresenterImp(this);
        treaSurePresenter.loadLunbotu();
    }

    @Override
    protected void loadData() {
        treaSurePresenter.loadTreSure(0);
    }


    @Override
    public void showTreSure(TreaSureBean treaSure) {
        TreaSureBean.DataBean data = treaSure.getData();
        title.add("智能筛选");
        title.add("赞数最多");
        title.add("最新评论");
        List<TreaSureBean.DataBean.ArtcircleCategoriesBean> artcircleCategories = data.getArtcircleCategories();
        for (TreaSureBean.DataBean.ArtcircleCategoriesBean artcircleCategory : artcircleCategories) {
            String name = artcircleCategory.getName();
            title.add(name);
        }
        for (int i = 0; i <title.size() ; i++) {
            TreasureTwoFragment treasureTwoFragment = new TreasureTwoFragment();
            mFragment.add(treasureTwoFragment);
            Bundle bundle = new Bundle();
            bundle.putInt("id",i);
            treasureTwoFragment.setArguments(bundle);


        }
       TreaFragmentAdapter treaFragmentAdapter = new TreaFragmentAdapter(getActivity().getSupportFragmentManager(), title, mFragment);
        treasure_viewpager.setAdapter(treaFragmentAdapter);
        tres_tabla.setupWithViewPager(treasure_viewpager);
        reflex(tres_tabla);


    }
    public void reflex(final TabLayout tabLayout){
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);

                    int dp10 = dip2px(tabLayout.getContext(), 10);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(5, 5);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static int dip2px(Context context,float dpValue){

        final float scale=context.getResources().getDisplayMetrics().density;

        return (int)(dpValue*scale+0.5f);

    }

    @Override
    public void showLunbotu(TreaSureLunBoTuBean treaSureLunBoTu) {
        ArrayList<String> imgurl = new ArrayList<>();
        List<TreaSureLunBoTuBean.DataBean.ListBean> list = treaSureLunBoTu.getData().getList();
        for (TreaSureLunBoTuBean.DataBean.ListBean listBean : list) {
            String mobileImgUrl = listBean.getMobileImgUrl();
            imgurl.add(mobileImgUrl);
        }
        treasure_fly.setImagesUrl(imgurl);
    }



}
