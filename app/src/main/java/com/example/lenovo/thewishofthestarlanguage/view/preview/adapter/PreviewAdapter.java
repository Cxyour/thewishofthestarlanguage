package com.example.lenovo.thewishofthestarlanguage.view.preview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewBean;
import com.example.lenovo.thewishofthestarlanguage.view.preview.activity.PrevieDetailsActivity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.Holder> {
    List<PreviewBean.DataBean.ListBean> list;
    Context context;

    public PreviewAdapter(List<PreviewBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.preview_item, null);

        return new Holder(inflate);
    }


    @Override
    public void onBindViewHolder(Holder holder, int position) {
        PreviewBean.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getCoverImg()).into(holder.title_img);
        holder.dizhi.setText("地址:"+listBean.getAddress());
        holder.yuyue.setText("已预约:"+listBean.getReservationNum()+"/"+listBean.getSubscribeNum());
        holder.qian.setText(listBean.getPrice()+".0");
        Date date = new Date(listBean.getStartDate());
        holder.rootView.setTag(position);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        String format = simpleDateFormat.format(date);
        holder.sj.setText(format);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }




    public  class Holder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView title_img;
        public TextView dizhi;
        public TextView yuyue;
        public TextView qian;
        public  TextView sj;
        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.title_img = (ImageView) rootView.findViewById(R.id.title_img);
            this.dizhi = (TextView) rootView.findViewById(R.id.dizhi);
            this.yuyue = (TextView) rootView.findViewById(R.id.yuyue);
            this.qian = (TextView) rootView.findViewById(R.id.qian);
            this.sj= rootView.findViewById(R.id.sj);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    PreviewBean.DataBean.ListBean listBean = list.get(tag);
                    int id = listBean.getId();
                    Intent intent = new Intent(context, PrevieDetailsActivity.class);
                    intent.putExtra("id",id);
                    context.startActivity(intent);
                }
            });
        }

    }



}
