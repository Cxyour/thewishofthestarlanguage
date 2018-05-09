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
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterBean;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.MasterDetailActivity;

import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.Holder> {
    List<MasterBean.DataBean.ListBean> list;
    Context context;

    public MasterAdapter(List<MasterBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.master_item, parent, false);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final MasterBean.DataBean.ListBean listBean = list.get(position);

        Glide.with(context).load(listBean.getImages()).into(holder.images);
        holder.nickname.setText(listBean.getNickname());
        holder.intro.setText(listBean.getIntro());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MasterDetailActivity.class);
                intent.putExtra("teacherId",listBean.get_$Id226());
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
        public ImageView images;
        public TextView nickname;
        public ImageView vvv;
        public  TextView intro;
        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.images = (ImageView) rootView.findViewById(R.id.images);
            this.nickname = (TextView) rootView.findViewById(R.id.nickname);
            this.vvv = (ImageView) rootView.findViewById(R.id.vvv);
            this.intro=rootView.findViewById(R.id.intro);

        }

    }
}
