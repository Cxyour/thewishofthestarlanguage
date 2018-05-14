package com.example.lenovo.thewishofthestarlanguage.view.base;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.thewishofthestarlanguage.model.config.App;


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
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void loadData();

    public void setContentView(int container, Class<? extends BaseFragment> fragmentClass) {

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
        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
        lastFragment = (BaseFragment) fragment;
    }


}
