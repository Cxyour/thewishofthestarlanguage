package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ILovesContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LovesBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.LovesPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.CollegesAdapter;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.MajorsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoveActivity extends BaseActivity implements ILovesContract.ILovesView, View.OnClickListener {

    private TextView loves_jump;
    private GridView loves_major_check;
    private GridView loves_school_check;
    private LovesPresenterImp lovesPresenterImp;
    private List<Integer> majorsIds = new ArrayList<>();
    private List<Integer> collegesIds = new ArrayList<>();
    private SharedPreferences user;
    private SharedPreferences.Editor edit;
    private Button loves_bottom;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_love;
    }

    @Override
    protected void init() {
        loves_jump = (TextView) findViewById(R.id.loves_jump);
        loves_major_check = (GridView) findViewById(R.id.loves_major_check);
        loves_school_check = (GridView) findViewById(R.id.loves_school_check);
        loves_bottom = (Button) findViewById(R.id.loves_bottom);
        loves_bottom.setOnClickListener(this);
        loves_jump.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        lovesPresenterImp = new LovesPresenterImp(this);
        lovesPresenterImp.loadLovesBean();
    }

    @Override
    public void showMajorsBean(final List<LovesBean.DataBean.MajorsBean> majorsBeans) {
        MajorsAdapter majorsAdapter = new MajorsAdapter(majorsBeans);
        loves_major_check.setAdapter(majorsAdapter);
        loves_major_check.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int majorsId = majorsBeans.get(position).getId();
                majorsIds.add(majorsId);
            }
        });
    }

    @Override
    public void showCollegesBean(final List<LovesBean.DataBean.CollegesBean> collegesBeans) {
        CollegesAdapter collegesAdapter = new CollegesAdapter(collegesBeans);
        loves_school_check.setAdapter(collegesAdapter);
        loves_school_check.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int collegesId = collegesBeans.get(position).getId();
                collegesIds.add(collegesId);
            }
        });
    }

    @Override
    public void showSaveLovesMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loves_jump:
                finish();
                break;
            case R.id.loves_bottom:
                lovesPresenterImp.saveLoves(user.getInt("user_id", 0), majorsIds, collegesIds);
                finish();
                break;
        }
    }
}
