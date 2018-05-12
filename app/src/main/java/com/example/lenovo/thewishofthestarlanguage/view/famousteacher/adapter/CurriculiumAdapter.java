package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.LiveDetailsActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public class CurriculiumAdapter extends RecyclerView.Adapter<CurriculiumAdapter.Holder> {
    List<TaskBean.DataBean.ListBean> list;
    Context context;

    public CurriculiumAdapter(List<TaskBean.DataBean.ListBean> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.liveing_item1, null);
        return new Holder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final TaskBean.DataBean.ListBean listBean = list.get(position);

        Glide.with(context).load(listBean.getCoverImg()).into(holder.coverImg);
        holder.realname.setText(listBean.getRealname());
        holder.isSubscribe.setText("已预约:"+listBean.getIsSubscribe()+"/"+listBean.getSubscribeNum());
        holder.replay.setText("￥"+listBean.getReplay());
        Date date = new Date(listBean.getStartDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
        String format = simpleDateFormat.format(date);
        holder.startDate.setText("开课时间:  "+format);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LiveDetailsActivity.class);
                int id = listBean.getId();
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView coverImg;
        public TextView startDate;
        public TextView realname;
        public ImageView vvv;
        public TextView isSubscribe;
        public TextView replay;

        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.coverImg = (ImageView) rootView.findViewById(R.id.coverImg);
            this.startDate = (TextView) rootView.findViewById(R.id.startDate);
            this.realname = (TextView) rootView.findViewById(R.id.realname);
            this.vvv = (ImageView) rootView.findViewById(R.id.vvv);
            this.isSubscribe = (TextView) rootView.findViewById(R.id.isSubscribe);
            this.replay = (TextView) rootView.findViewById(R.id.replay);

        }

    }
}
