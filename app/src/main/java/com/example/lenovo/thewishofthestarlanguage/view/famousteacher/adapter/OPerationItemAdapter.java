package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public class OPerationItemAdapter extends RecyclerView.Adapter<OPerationItemAdapter.Holder> {
    List<OperationBean.DataBean.CommentsBean.ListBean> list;
    Context context;
    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月

    public OPerationItemAdapter(List<OperationBean.DataBean.CommentsBean.ListBean> list) {
        this.list = list;
    }

    private final static long year = 12 * month;// 年
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.operation_item2, null);

        return new Holder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        OperationBean.DataBean.CommentsBean.ListBean listBean = list.get(position);
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
