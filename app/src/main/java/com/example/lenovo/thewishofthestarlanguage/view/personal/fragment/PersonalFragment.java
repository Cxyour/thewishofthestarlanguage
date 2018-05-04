package com.example.lenovo.thewishofthestarlanguage.view.personal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.RegisterActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.SetActivity;

public class PersonalFragment extends BaseFragment implements View.OnClickListener {


    private ImageView home_myselft_fragment_message;
    private ImageView home_myselft_fragment_message_newimg;
    private RelativeLayout home_myself_message;
    private ImageView home_myselft_fragment_setting;
    private ImageView home_myselft_notlogin_img;
    private RelativeLayout home_myselft_fragment_nologin_head;
    private TextView home_myself_fragment_username;
    private LinearLayout home_myself_fragment_userinfo_group;
    private LinearLayout home_myselft_fragment_livebtn;
    private RelativeLayout home_myselft_fragment_login_head;
    private Button home_myselft_register_btn;
    private Button home_myselft_login_btn;
    private LinearLayout home_myselft_fragment_nologin_body;
    private TextView home_myselft_fragment_homewokCount_tv;
    private TextView home_myselft_fragment_homewokCount_status;
    private LinearLayout home_myselft_fragment_homewokCount_group;
    private TextView home_myselft_fragment_artcircleCount_tv;
    private LinearLayout home_myselft_fragment_tiezi_group;
    private TextView home_myselft_fragment_attentionCount_tv;
    private LinearLayout home_myselft_fragment_guanzhu_group;
    private TextView home_myselft_fragment_fansCount_tv;
    private LinearLayout home_myselft_fragment_fensi_group;
    private LinearLayout home_myselft_fragment_teacher_daizhibo;
    private LinearLayout home_myselft_fragment_teacher_daizuoye;
    private LinearLayout home_myselft_fragment_teacher_daifudao;
    private LinearLayout home_myselft_fragment_teacher_jiaoxue;
    private LinearLayout home_myselft_fragment_teacher_toolline;
    private LinearLayout home_myselft_fragment_student_fukuan;
    private LinearLayout home_myselft_fragment_student_shiyong;
    private LinearLayout home_myselft_fragment_student_tuiguo;
    private LinearLayout home_myselft_fragment_student_dingdan;
    private LinearLayout home_myselft_fragment_student_toolline;
    private TextView home_myself_fragment_jindou_tv;
    private RelativeLayout home_myself_fragment_jindou_group;
    private RelativeLayout home_myselft_fragment_havegift_group;
    private RelativeLayout home_myselft_fragment_favorites;
    private RelativeLayout home_myself_fragment_selectmajor;
    private TextView home_myself_fragment_isauth_tv;
    private RelativeLayout home_myselft_fragment_approve;
    private LinearLayout home_myselft_fragment_login_body;
    private Intent intent;

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
        home_myself_fragment_username = (TextView) view.findViewById(R.id.home_myself_fragment_username);
        home_myself_fragment_userinfo_group = (LinearLayout) view.findViewById(R.id.home_myself_fragment_userinfo_group);
        home_myselft_fragment_livebtn = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_livebtn);
        home_myselft_fragment_login_head = (RelativeLayout) view.findViewById(R.id.home_myselft_fragment_login_head);
        home_myselft_register_btn = (Button) view.findViewById(R.id.home_myselft_register_btn);
        home_myselft_login_btn = (Button) view.findViewById(R.id.home_myselft_login_btn);
        home_myselft_fragment_nologin_body = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_nologin_body);
        home_myselft_fragment_homewokCount_tv = (TextView) view.findViewById(R.id.home_myselft_fragment_homewokCount_tv);
        home_myselft_fragment_homewokCount_status = (TextView) view.findViewById(R.id.home_myselft_fragment_homewokCount_status);
        home_myselft_fragment_homewokCount_group = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_homewokCount_group);
        home_myselft_fragment_artcircleCount_tv = (TextView) view.findViewById(R.id.home_myselft_fragment_artcircleCount_tv);
        home_myselft_fragment_tiezi_group = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_tiezi_group);
        home_myselft_fragment_attentionCount_tv = (TextView) view.findViewById(R.id.home_myselft_fragment_attentionCount_tv);
        home_myselft_fragment_guanzhu_group = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_guanzhu_group);
        home_myselft_fragment_fansCount_tv = (TextView) view.findViewById(R.id.home_myselft_fragment_fansCount_tv);
        home_myselft_fragment_fensi_group = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_fensi_group);
        home_myselft_fragment_teacher_daizhibo = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_teacher_daizhibo);
        home_myselft_fragment_teacher_daizuoye = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_teacher_daizuoye);
        home_myselft_fragment_teacher_daifudao = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_teacher_daifudao);
        home_myselft_fragment_teacher_jiaoxue = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_teacher_jiaoxue);
        home_myselft_fragment_teacher_toolline = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_teacher_toolline);
        home_myselft_fragment_student_fukuan = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_student_fukuan);
        home_myselft_fragment_student_shiyong = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_student_shiyong);
        home_myselft_fragment_student_tuiguo = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_student_tuiguo);
        home_myselft_fragment_student_dingdan = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_student_dingdan);
        home_myselft_fragment_student_toolline = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_student_toolline);
        home_myself_fragment_jindou_tv = (TextView) view.findViewById(R.id.home_myself_fragment_jindou_tv);
        home_myself_fragment_jindou_group = (RelativeLayout) view.findViewById(R.id.home_myself_fragment_jindou_group);
        home_myselft_fragment_havegift_group = (RelativeLayout) view.findViewById(R.id.home_myselft_fragment_havegift_group);
        home_myselft_fragment_favorites = (RelativeLayout) view.findViewById(R.id.home_myselft_fragment_favorites);
        home_myself_fragment_selectmajor = (RelativeLayout) view.findViewById(R.id.home_myself_fragment_selectmajor);
        home_myself_fragment_isauth_tv = (TextView) view.findViewById(R.id.home_myself_fragment_isauth_tv);
        home_myselft_fragment_approve = (RelativeLayout) view.findViewById(R.id.home_myselft_fragment_approve);
        home_myselft_fragment_login_body = (LinearLayout) view.findViewById(R.id.home_myselft_fragment_login_body);

        home_myselft_register_btn.setOnClickListener(this);
        home_myselft_login_btn.setOnClickListener(this);
        home_myselft_fragment_setting.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

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
                getActivity().startActivity(intent);
                break;

            case R.id.home_myselft_fragment_setting:
                intent = new Intent(getContext(), SetActivity.class);
                startActivity(intent);
                break;
        }
    }
}
