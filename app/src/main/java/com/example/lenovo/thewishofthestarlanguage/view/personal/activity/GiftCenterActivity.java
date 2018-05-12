package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.CashIncomeFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.ReceiveGiftFragment;

public class GiftCenterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView voucher_center_return;
    private TextView gift_center_receive_gift_x;
    private RadioButton gift_center_cash_income;
    private TextView gift_center_cash_income_x;
    private FrameLayout gift_center_container;
    private RadioButton gift_center_receive_gift;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gift_center;
    }

    @Override
    protected void init() {
        voucher_center_return = (ImageView) findViewById(R.id.voucher_center_return);
        gift_center_receive_gift = (RadioButton) findViewById(R.id.gift_center_receive_gift);
        gift_center_receive_gift_x = (TextView) findViewById(R.id.gift_center_receive_gift_x);
        gift_center_cash_income = (RadioButton) findViewById(R.id.gift_center_cash_income);
        gift_center_cash_income_x = (TextView) findViewById(R.id.gift_center_cash_income_x);
        gift_center_container = (FrameLayout) findViewById(R.id.gift_center_container);

        voucher_center_return.setOnClickListener(this);
        gift_center_receive_gift.setOnClickListener(this);
        gift_center_cash_income.setOnClickListener(this);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.gift_center_container, new ReceiveGiftFragment());
        transaction.commit();

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.voucher_center_return:
                finish();
                break;
            case R.id.gift_center_receive_gift:
                changeFragment(new ReceiveGiftFragment());
                gift_center_receive_gift_x.setVisibility(View.VISIBLE);
                gift_center_cash_income_x.setVisibility(View.GONE);
                break;
            case R.id.gift_center_cash_income:
                changeFragment(new CashIncomeFragment());
                gift_center_receive_gift_x.setVisibility(View.GONE);
                gift_center_cash_income_x.setVisibility(View.VISIBLE);
                break;

        }
    }

    private void changeFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.gift_center_container, fragment);
        transaction.commit();
    }
}
