package com.example.lenovo.thewishofthestarlanguage.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.thewishofthestarlanguage.model.config.App;

import java.io.IOException;


/**
 * Created by Lenovo on 2018/4/4.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private BaseFragment lastFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.context = this;
        init();
        loadData();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void loadData();

    public void setContentView(int container, Class<? extends BaseFragment> fragmentClass, Bundle params) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        Fragment fragment = manager.findFragmentByTag(simpleName);
        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            transaction.add(container, fragment, simpleName);
        }
        if (params != null) {
            fragment.setArguments(params);
        }
        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);
        lastFragment = (BaseFragment) fragment;
        transaction.commit();
    }

}
