package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IPersonalMessageContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FollowBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyPersonalBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;
import com.example.lenovo.thewishofthestarlanguage.presenter.PersonalMessagePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.PostFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.fragment.WorksFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PersonalMessageActivity extends BaseActivity implements View.OnClickListener, IPersonalMessageContract.IPersonalMessageView {

    private ImageView my_personal_message_return;
    private ImageView my_personal_message_icon;
    private CheckBox my_personal_message_follow;
    private TextView my_personal_message_nickname;
    private TextView my_personal_message_follow_count_num;
    private TextView my_personal_message_fans_count_num;
    private TextView my_personal_message_works_x;
    private RadioButton my_personal_message_works_change;
    private TextView my_personal_message_post_x;
    private RadioButton my_personal_message_post_change;
    private FrameLayout my_personal_message_container;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;
    private int id;
    private PersonalMessagePresenterImp PersonalMessagePresenterImp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_personal_message;
    }

    @Override
    protected void init() {
        my_personal_message_return = (ImageView) findViewById(R.id.my_personal_message_return);
        my_personal_message_icon = (ImageView) findViewById(R.id.my_personal_message_icon);
        my_personal_message_follow = (CheckBox) findViewById(R.id.my_personal_message_follow);
        my_personal_message_nickname = (TextView) findViewById(R.id.my_personal_message_nickname);
        my_personal_message_follow_count_num = (TextView) findViewById(R.id.my_personal_message_follow_count_num);
        my_personal_message_fans_count_num = (TextView) findViewById(R.id.my_personal_message_fans_count_num);
        my_personal_message_works_x = (TextView) findViewById(R.id.my_personal_message_works_x);
        my_personal_message_works_change = findViewById(R.id.my_personal_message_works_change);
        my_personal_message_post_x = (TextView) findViewById(R.id.my_personal_message_post_x);
        my_personal_message_post_change = findViewById(R.id.my_personal_message_post_change);
        my_personal_message_container = (FrameLayout) findViewById(R.id.my_personal_message_container);
        my_personal_message_works_change.setOnClickListener(this);
        my_personal_message_return.setOnClickListener(this);
        my_personal_message_follow.setOnClickListener(this);
        my_personal_message_post_change.setOnClickListener(this);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.my_personal_message_container, new WorksFragment());
        transaction.commit();
    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        PersonalMessagePresenterImp = new PersonalMessagePresenterImp(this);
        PersonalMessagePresenterImp.loadMyPersonalMessage(user.getInt("user_id", 0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_personal_message_return:
                finish();
                break;
            case R.id.my_personal_message_follow:
                if (my_personal_message_follow.isChecked()) {
                    PersonalMessagePresenterImp.followPersonal(id);
                    my_personal_message_follow.setText("已关注");
                    my_personal_message_follow.setTextColor(Color.parseColor("#dddddd"));
                } else {
                    PersonalMessagePresenterImp.personalAbolishConcern(id, user.getInt("user_id", 0));
                    my_personal_message_follow.setText("关注");
                    my_personal_message_follow.setTextColor(Color.parseColor("#ffffff"));
                }
                break;
            case R.id.my_personal_message_works_change:
                my_personal_message_works_x.setVisibility(View.VISIBLE);
                my_personal_message_post_x.setVisibility(View.GONE);
                changeFragment(new WorksFragment());
                break;
            case R.id.my_personal_message_post_change:
                my_personal_message_works_x.setVisibility(View.GONE);
                my_personal_message_post_x.setVisibility(View.VISIBLE);
                changeFragment(new PostFragment());
                break;

        }
    }

    private void changeFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.my_personal_message_container, fragment);
        transaction.commit();
    }

    @Override
    public void showMyPersonalMessage(MyPersonalBean myPersonalBean) {
        Glide.with(this).load(myPersonalBean.getData().getPhoto()).asBitmap().into(new ImageViewTarget<Bitmap>(my_personal_message_icon) {
            @Override
            protected void setResource(Bitmap bitmap) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                drawable.setCircular(true);
                my_personal_message_icon.setBackground(drawable);
            }
        });
        if (myPersonalBean.getData().getIsPreference() == 0) {
            my_personal_message_follow.setChecked(false);
        } else {
            my_personal_message_follow.setChecked(true);
        }
        my_personal_message_nickname.setText(myPersonalBean.getData().getNickname());
        my_personal_message_follow_count_num.setText(String.valueOf(myPersonalBean.getData().getFavoriteCount()));
        my_personal_message_fans_count_num.setText(String.valueOf(myPersonalBean.getData().getFansCount()));
    }

    @Override
    public void showFollowStatus(String string) {
        Toast.makeText(PersonalMessageActivity.this, "关注" + string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAbolishConcern(String string) {
        Toast.makeText(PersonalMessageActivity.this, "取消关注" + string, Toast.LENGTH_SHORT).show();
    }
}
