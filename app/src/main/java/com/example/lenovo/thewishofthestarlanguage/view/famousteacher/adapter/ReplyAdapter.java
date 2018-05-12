package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyTwoBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.OperationPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/11.
 */

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.Holder> {
    List<ReplyTwoBean.DataBean.CommentsBean.ListBean> list;
    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年
    Context context;
    OperationPresenterImp operationPresenterImp;
    public ReplyAdapter(  List<ReplyTwoBean.DataBean.CommentsBean.ListBean> list) {
        this.list = list;
    }

    public ReplyAdapter(  List<ReplyTwoBean.DataBean.CommentsBean.ListBean> list, OperationPresenterImp operationPresenterImp) {
        this.list = list;
        this.operationPresenterImp = operationPresenterImp;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.operation_item2, null);

        return new Holder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        ReplyTwoBean.DataBean.CommentsBean.ListBean listBean = list.get(position);
        holder.contentMeg.setText(listBean.getContent());
        holder.name.setText(listBean.getNickname());
        holder.opera_zan.setText(listBean.getIsPraise()+"");
        Glide.with(context).load(listBean.getPhoto()).asBitmap().into(new BitmapImageViewTarget(holder.pohot){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                holder.pohot.setImageDrawable(roundedBitmapDrawable);
            }
        });
        Date date = new Date(listBean.getCreateDate());
        String timeFormatText = getTimeFormatText(date);
        holder.sj.setText(timeFormatText);
        zan(holder,position);

    }

    private void zan(final Holder holder, final int position){

        holder.opera_zan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                boolean isLogin = sp.getBoolean("isLogin", false);
                ReplyTwoBean.DataBean.CommentsBean.ListBean listBean = list.get(position);
                int userId = listBean.getUserId();
                int id = listBean.getId();

                int user_id = sp.getInt("user_id", 0);
                HashMap<String, String> parmas = new HashMap<>();
                parmas.put("userId", String.valueOf(userId));
                parmas.put("id", String.valueOf(id));
                parmas.put("loginUserId", String.valueOf(user_id));
                parmas.put("type", "艺考圈作品");
                if (isLogin==true){
                    if (isChecked==true) {
                        operationPresenterImp.loadGoodBean(parmas);
                        holder.opera_zan.setText(listBean.getPraiseNum()+1+"");

                    }else {
                        operationPresenterImp.CancelthePraise(parmas);
                        SharedPreferences.Editor edit = sp.edit();
                    }
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }

            }
        });

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static String getTimeFormatText(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }


    class Holder  extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView pohot;
        public TextView name;
        public TextView contentMeg;
        public TextView sj;
        public CheckBox opera_zan;
        public TextView huifu;

        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.pohot = (ImageView) rootView.findViewById(R.id.pohot);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.contentMeg = (TextView) rootView.findViewById(R.id.contentMeg);
            this.sj = (TextView) rootView.findViewById(R.id.sj);
            this.opera_zan = (CheckBox) rootView.findViewById(R.id.opera_zan);
            this.huifu = (TextView) rootView.findViewById(R.id.huifu);
        }

    }
}
