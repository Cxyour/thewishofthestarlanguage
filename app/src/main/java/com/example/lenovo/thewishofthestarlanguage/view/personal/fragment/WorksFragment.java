package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;

public class WorksFragment extends BaseFragment {

    private LinearLayout works_fragment_nothing;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_works;
    }

    @Override
    protected void init(View view) {
        works_fragment_nothing = view.findViewById(R.id.works_fragment_nothing);
    }

    @Override
    protected void loadData() {

    }

}
