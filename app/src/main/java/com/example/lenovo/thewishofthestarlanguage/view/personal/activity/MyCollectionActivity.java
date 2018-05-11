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
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.EavesdroppingHomeworkFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.ExperienceCourseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.LiveCourseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.PostFragment;

public class MyCollectionActivity extends BaseActivity implements View.OnClickListener {

    private ImageView voucher_center_return;
    private RadioButton my_collection_live_course;
    private TextView my_collection_live_course_x;
    private RadioButton my_collection_experience_course;
    private TextView my_collection_experience_course_x;
    private RadioButton my_collection_eavesdropping_homework;
    private TextView my_collection_eavesdropping_homework_x;
    private RadioButton my_collection_post;
    private TextView my_collection_post_x;
    private FrameLayout my_collection_container;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void init() {
        voucher_center_return = (ImageView) findViewById(R.id.voucher_center_return);
        my_collection_live_course = (RadioButton) findViewById(R.id.my_collection_live_course);
        my_collection_live_course_x = (TextView) findViewById(R.id.my_collection_live_course_x);
        my_collection_experience_course = (RadioButton) findViewById(R.id.my_collection_experience_course);
        my_collection_experience_course_x = (TextView) findViewById(R.id.my_collection_experience_course_x);
        my_collection_eavesdropping_homework = (RadioButton) findViewById(R.id.my_collection_eavesdropping_homework);
        my_collection_eavesdropping_homework_x = (TextView) findViewById(R.id.my_collection_eavesdropping_homework_x);
        my_collection_post = (RadioButton) findViewById(R.id.my_collection_post);
        my_collection_post_x = (TextView) findViewById(R.id.my_collection_post_x);
        my_collection_container = (FrameLayout) findViewById(R.id.my_collection_container);

        voucher_center_return.setOnClickListener(this);
        my_collection_live_course.setOnClickListener(this);
        my_collection_experience_course.setOnClickListener(this);
        my_collection_eavesdropping_homework.setOnClickListener(this);
        my_collection_post.setOnClickListener(this);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.my_collection_container, new LiveCourseFragment());
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
            case R.id.my_collection_live_course:
                my_collection_live_course_x.setVisibility(View.VISIBLE);
                my_collection_experience_course_x.setVisibility(View.GONE);
                my_collection_eavesdropping_homework_x.setVisibility(View.GONE);
                my_collection_post_x.setVisibility(View.GONE);
                changeFragment(new LiveCourseFragment());
                break;
            case R.id.my_collection_experience_course:
                my_collection_live_course_x.setVisibility(View.GONE);
                my_collection_experience_course_x.setVisibility(View.VISIBLE);
                my_collection_eavesdropping_homework_x.setVisibility(View.GONE);
                my_collection_post_x.setVisibility(View.GONE);
                changeFragment(new ExperienceCourseFragment());
                break;
            case R.id.my_collection_eavesdropping_homework:
                my_collection_live_course_x.setVisibility(View.GONE);
                my_collection_experience_course_x.setVisibility(View.GONE);
                my_collection_eavesdropping_homework_x.setVisibility(View.VISIBLE);
                my_collection_post_x.setVisibility(View.GONE);
                changeFragment(new EavesdroppingHomeworkFragment());
                break;
            case R.id.my_collection_post:
                my_collection_live_course_x.setVisibility(View.GONE);
                my_collection_experience_course_x.setVisibility(View.GONE);
                my_collection_eavesdropping_homework_x.setVisibility(View.GONE);
                my_collection_post_x.setVisibility(View.VISIBLE);
                changeFragment(new PostFragment());
                break;
        }
    }

    private void changeFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.my_collection_container, fragment);
        transaction.commit();
    }
}
