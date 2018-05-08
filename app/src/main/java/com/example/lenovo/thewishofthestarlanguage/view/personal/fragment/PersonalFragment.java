package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.RegisterActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.SetActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.mymessage.MyselfMessageActivity;
import com.example.lenovo.thewishofthestarlanguage.view.ui.MessageActivity;

public class PersonalFragment extends BaseFragment implements View.OnClickListener {


    private Intent intent;
    private ImageView home_myselft_fragment_message;
    private ImageView home_myselft_fragment_message_newimg;
    private RelativeLayout home_myself_message;
    private ImageView home_myselft_fragment_setting;
    private ImageView home_myselft_notlogin_img;
    private RelativeLayout home_myselft_fragment_nologin_head;
    private ImageView personal_myself_icon;
    private TextView myself_message;
    private RelativeLayout personal_myself_message;
    private TextView personal_myself_nickName;
    private LinearLayout personal_myself_personal_message;
    private Button home_myselft_register_btn;
    private Button home_myselft_login_btn;
    private LinearLayout home_myselft_fragment_nologin_body;
    private TextView personal_myself_works_count;
    private LinearLayout personal_myself_works;
    private TextView personal_myself_post_count;
    private LinearLayout personal_myself_post;
    private TextView personal_myself_follow_count;
    private LinearLayout personal_myself_follow;
    private TextView personal_myself_fans_count;
    private LinearLayout personal_myself_fans;
    private TextView personal_myself_substitute_payment;
    private TextView personal_myself_substitute_for_use;
    private TextView personal_myself_substitute_for_return;
    private TextView personal_myself_my_order;
    private LinearLayout personal_myself_function;
    private ImageView personal_myself_recharge_center;
    private TextView personal_myself_gold_bean_count;
    private ImageView personal_myself_gold_bean;
    private RelativeLayout personal_myself_voucher_center;
    private RelativeLayout personal_myself_gift_center;
    private RelativeLayout personal_myself_my_collection;
    private RelativeLayout personal_myself_my_preference;
    private ImageView personal_myself_authentication_go;
    private RelativeLayout personal_myself_authentication;
    private LinearLayout personal_login_message;
    private SharedPreferences preferences;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void init(View view) {
        home_myselft_fragment_message = (ImageView) view.findViewById(R.id.home_myselft_fragment_message);
        home_myselft_fragment_message_newimg = (ImageView) view.findViewById(R.id.home_myselft_fragment_message_newimg);
        home_myself_message = (RelativeLayout) view.findViewById(R.id.home_myself_message);
        home_myselft_fragment_setting = (ImageView) view.findViewById(R.id.home_myselft_fragment_setting);
        home_myselft_notlogin_img = (ImageView) view.findViewById(R.id.home_myselft_notlogin_img);
        home_myselft_fragment_nologin_head = (RelativeLayout) view.findViewById(R.id.home_myselft_fragment_nologin_head);
        personal_myself_icon = (ImageView) view.findViewById(R.id.personal_myself_icon);
        myself_message = (TextView) view.findViewById(R.id.myself_message);
        personal_myself_message = (RelativeLayout) view.findViewById(R.id.personal_myself_message);
        personal_myself_nickName = (TextView) view.findViewById(R.id.personal_myself_nickName);
        personal_myself_personal_message = (LinearLayout) view.findViewById(R.id.personal_myself_personal_message);
        home_myselft_register_btn = (Button) view.findViewById(R.id.home_myselft_register_btn);
        home_myselft_login_btn = (Button) view.findViewById(R.id.home_myselft_login_btn);
        home_myselft_fragment_nologin_body = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_nologin_body);
        personal_myself_works_count = (TextView) view.findViewById(R.id.personal_myself_works_count);
        personal_myself_works = (LinearLayout) view.findViewById(R.id.personal_myself_works);
        personal_myself_post_count = (TextView) view.findViewById(R.id.personal_myself_post_count);
        personal_myself_post = (LinearLayout) view.findViewById(R.id.personal_myself_post);
        personal_myself_follow_count = (TextView) view.findViewById(R.id.personal_myself_follow_count);
        personal_myself_follow = (LinearLayout) view.findViewById(R.id.personal_myself_follow);
        personal_myself_fans_count = (TextView) view.findViewById(R.id.personal_myself_fans_count);
        personal_myself_fans = (LinearLayout) view.findViewById(R.id.personal_myself_fans);
        personal_myself_substitute_payment = (TextView) view.findViewById(R.id.personal_myself_substitute_payment);
        personal_myself_substitute_for_use = (TextView) view.findViewById(R.id.personal_myself_substitute_for_use);
        personal_myself_substitute_for_return = (TextView) view.findViewById(R.id.personal_myself_substitute_for_return);
        personal_myself_my_order = (TextView) view.findViewById(R.id.personal_myself_my_order);
        personal_myself_function = (LinearLayout) view.findViewById(R.id.personal_myself_function);
        personal_myself_recharge_center = (ImageView) view.findViewById(R.id.personal_myself_recharge_center);
        personal_myself_gold_bean_count = (TextView) view.findViewById(R.id.personal_myself_gold_bean_count);
        personal_myself_gold_bean = (ImageView) view.findViewById(R.id.personal_myself_gold_bean);
        personal_myself_voucher_center = (RelativeLayout) view.findViewById(R.id.personal_myself_voucher_center);
        personal_myself_gift_center = (RelativeLayout) view.findViewById(R.id.personal_myself_gift_center);
        personal_myself_my_collection = (RelativeLayout) view.findViewById(R.id.personal_myself_my_collection);
        personal_myself_my_preference = (RelativeLayout) view.findViewById(R.id.personal_myself_my_preference);
        personal_myself_authentication_go = (ImageView) view.findViewById(R.id.personal_myself_authentication_go);
        personal_myself_authentication = (RelativeLayout) view.findViewById(R.id.personal_myself_authentication);
        personal_login_message = (LinearLayout) view.findViewById(R.id.personal_login_message);
        home_myselft_fragment_setting.setOnClickListener(this);
        home_myselft_register_btn.setOnClickListener(this);
        home_myselft_login_btn.setOnClickListener(this);
        home_myselft_fragment_message.setOnClickListener(this);
        personal_myself_message.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        preferences = getActivity().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_myselft_register_btn:
                intent = new Intent(getContext(), RegisterActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.home_myselft_login_btn:
                intent = new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.home_myselft_fragment_setting:
                if (preferences.getBoolean("isLogin", false)) {
                    intent = new Intent(getContext(), SetActivity.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }
                break;

            case R.id.personal_myself_message:
                intent = new Intent(getContext(), MyselfMessageActivity.class);
                startActivity(intent);
                break;
            case R.id.home_myselft_fragment_message:
                if (preferences.getBoolean("isLogin",false)){
                    intent = new Intent(getContext(), MessageActivity.class);
                    startActivity(intent);
                }else {
                    intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (preferences.getBoolean("isLogin", false)) {
            home_myselft_fragment_nologin_head.setVisibility(View.GONE);
            home_myselft_fragment_nologin_body.setVisibility(View.GONE);
            personal_myself_personal_message.setVisibility(View.VISIBLE);
            personal_login_message.setVisibility(View.VISIBLE);
            Glide.with(this).load(preferences.getString("photo", "")).asBitmap().into(new ImageViewTarget<Bitmap>(personal_myself_icon) {
                @Override
                protected void setResource(Bitmap bitmap) {
                    RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                    drawable.setCircular(true);
                    personal_myself_icon.setBackground(drawable);

                }
            });
            personal_myself_nickName.setText(preferences.getString("nickname", ""));
        } else {
            home_myselft_fragment_nologin_head.setVisibility(View.VISIBLE);
            home_myselft_fragment_nologin_body.setVisibility(View.VISIBLE);
            personal_myself_personal_message.setVisibility(View.GONE);
            personal_login_message.setVisibility(View.GONE);
        }
    }

}
