package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment.AmanFragment;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment.MasterFragment;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment.MingShiFragment;

public class FamousTeacherActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton intelig_But;
    private TextView home_work_fragment_capacity_line;
    private RadioButton mostEave_But;
    private TextView home_work_fragment_capacity_line2;
    private RadioButton theLatesr_But;
    private TextView home_work_fragment_capacity_line3;
    private FrameLayout famous_activity;
    private FragmentManager supportFragmentManager;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_teacher);
        initView();
    }

    private void initView() {
        intelig_But = (RadioButton) findViewById(R.id.intelig_But);
        home_work_fragment_capacity_line = (TextView) findViewById(R.id.home_work_fragment_capacity_line);
        mostEave_But = (RadioButton) findViewById(R.id.mostEave_But);
        home_work_fragment_capacity_line2 = (TextView) findViewById(R.id.home_work_fragment_capacity_line2);
        theLatesr_But = (RadioButton) findViewById(R.id.theLatesr_But);
        home_work_fragment_capacity_line3 = (TextView) findViewById(R.id.home_work_fragment_capacity_line3);
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.famous_activity, new MasterFragment());
        transaction.commit();
        intelig_But.setOnClickListener(this);
        mostEave_But.setOnClickListener(this);
        theLatesr_But.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intelig_But:
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.replace(R.id.famous_activity, new MasterFragment());
                transaction.commit();
                home_work_fragment_capacity_line.setVisibility(View.VISIBLE);
                home_work_fragment_capacity_line2.setVisibility(View.GONE);
                home_work_fragment_capacity_line3.setVisibility(View.GONE);
                break;
            case R.id.mostEave_But:
                FragmentTransaction transaction2 = supportFragmentManager.beginTransaction();
                transaction2.replace(R.id.famous_activity, new MingShiFragment());
                transaction2.commit();
                home_work_fragment_capacity_line.setVisibility(View.GONE);
                home_work_fragment_capacity_line2.setVisibility(View.VISIBLE);
                home_work_fragment_capacity_line3.setVisibility(View.GONE);
                break;
            case R.id.theLatesr_But:
                FragmentTransaction transaction3 = supportFragmentManager.beginTransaction();
                transaction3.replace(R.id.famous_activity, new AmanFragment());
                transaction3.commit();
                home_work_fragment_capacity_line.setVisibility(View.GONE);
                home_work_fragment_capacity_line2.setVisibility(View.GONE);
                home_work_fragment_capacity_line3.setVisibility(View.VISIBLE);
                break;
        }
    }
}
