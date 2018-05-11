package com.example.lenovo.thewishofthestarlanguage.view.homework.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;


public class HomeWorkFragment extends BaseFragment implements View.OnClickListener {


    private RadioButton intelig_But;
    private RadioButton mostEave_But;
    private RadioButton theLatesr_But;
    private FragmentManager supportFragmentManager;
    private LinearLayout home_work_fragment_publishwok_group;
    private LinearLayout home_work_fragment_publishaskwok_group;
    private TextView home_work_fragment_capacity_line;
    private TextView home_work_fragment_capacity_line2;
    private TextView home_work_fragment_capacity_line3;
    private FrameLayout homework_frame;
    private FragmentTransaction transaction;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_work;
    }

    @Override
    protected void init(View view) {
        intelig_But = view.findViewById(R.id.intelig_But);
        mostEave_But = view.findViewById(R.id.mostEave_But);
        theLatesr_But = view.findViewById(R.id.theLatesr_But);
        home_work_fragment_capacity_line = view.findViewById(R.id.home_work_fragment_capacity_line);
        home_work_fragment_capacity_line2 = view.findViewById(R.id.home_work_fragment_capacity_line2);
        home_work_fragment_capacity_line3 = view.findViewById(R.id.home_work_fragment_capacity_line3);
        intelig_But.setOnClickListener(this);
        mostEave_But.setOnClickListener(this);
        theLatesr_But.setOnClickListener(this);
        home_work_fragment_capacity_line3.setOnClickListener(this);
        home_work_fragment_capacity_line2.setOnClickListener(this);
        home_work_fragment_capacity_line.setOnClickListener(this);
        supportFragmentManager = getActivity().getSupportFragmentManager();
    }

    @Override
    protected void loadData() {
        changeFragment(new IntelligentScreeningFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intelig_But:
                changeFragment(new IntelligentScreeningFragment());
                home_work_fragment_capacity_line.setVisibility(View.VISIBLE);
                home_work_fragment_capacity_line2.setVisibility(View.GONE);
                home_work_fragment_capacity_line3.setVisibility(View.GONE);
                break;
            case R.id.mostEave_But:
                changeFragment(new MostEavesdroppingFragment());
                home_work_fragment_capacity_line.setVisibility(View.GONE);
                home_work_fragment_capacity_line2.setVisibility(View.VISIBLE);
                home_work_fragment_capacity_line3.setVisibility(View.GONE);
                break;
            case R.id.theLatesr_But:
                changeFragment(new TheLatestReviewFragment());
                home_work_fragment_capacity_line.setVisibility(View.GONE);
                home_work_fragment_capacity_line2.setVisibility(View.GONE);
                home_work_fragment_capacity_line3.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void changeFragment(Fragment fragment) {
        transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.homework_frame, fragment);
        transaction.commit();
    }

}
