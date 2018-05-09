package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.presenter.MyOrderPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.MyOrderViewPagerAdapter;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.AllFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.SubstituteForReturnFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.SubstituteForUseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.SubstitutePaymentFragment;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends BaseActivity {

    private TabLayout my_order_tabLayout;
    private ViewPager my_order_viewPager;
    private MyOrderPresenterImp myOrderPresenterImp;
    private int position;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private MyOrderViewPagerAdapter myOrderViewPagerAdapter;
    private ImageView my_order_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_oorder;
    }

    @Override
    protected void init() {
        preferences = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = preferences.edit();
        my_order_tabLayout = (TabLayout) findViewById(R.id.my_order_tabLayout);
        my_order_tabLayout.setTabMode(TabLayout.MODE_FIXED);
        my_order_tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        my_order_tabLayout.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#000000"));
        my_order_viewPager = (ViewPager) findViewById(R.id.my_order_viewPager);
        my_order_viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        my_order_tabLayout.setupWithViewPager(my_order_viewPager);
        myOrderViewPagerAdapter = new MyOrderViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        my_order_viewPager.setAdapter(myOrderViewPagerAdapter);
        my_order_return = findViewById(R.id.my_order_return);
        my_order_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void loadData() {
        titles.add("全部");
        titles.add("待付款");
        titles.add("待使用");
        titles.add("退货");
        fragments.add(new AllFragment());
        fragments.add(new SubstitutePaymentFragment());
        fragments.add(new SubstituteForUseFragment());
        fragments.add(new SubstituteForReturnFragment());
        myOrderViewPagerAdapter.notifyDataSetChanged();
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        Log.e("position", String.valueOf(position));
        my_order_viewPager.setCurrentItem(position);
    }

}
