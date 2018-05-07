package com.example.lenovo.thewishofthestarlanguage.view.treasure.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class TreaFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<String> title;
    private  ArrayList<Fragment> mFragment;

    public TreaFragmentAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> mFragment) {
        super(fm);
        this.title = title;
        this.mFragment = mFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }


    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
