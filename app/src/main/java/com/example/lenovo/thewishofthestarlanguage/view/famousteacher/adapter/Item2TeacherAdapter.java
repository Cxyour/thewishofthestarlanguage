package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.MasterDetailActivity;

import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/4.
 */

public class Item2TeacherAdapter extends RecyclerView.Adapter<Item2TeacherAdapter.Holder> {

    private static final String TAG = "Item2TeacherAdapter";
    List<FamousTeacherBean.DataBean.UsersBean> list;
    Context context;

    public Item2TeacherAdapter(List<FamousTeacherBean.DataBean.UsersBean> list) {
        this.list = list;
        Log.d("123456", "Item2TeacherAdapter: " + list.size());
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.teacher_item1_item2, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }


    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.nickname_item.setText(list.get(position).getNickname());
        holder.intro_item.setText(list.get(position).getIntro());
        Glide.with(context).load(list.get(position).getImages()).into(holder.img_item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MasterDetailActivity.class);
                intent.putExtra("teacherId",list.get(position).getId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public ImageView img_item;
        public TextView nickname_item;
        public ImageView level_item;
        public TextView intro_item;

        public Holder(View itemView) {
            super(itemView);
            this.img_item = itemView.findViewById(R.id.img);
            this.nickname_item =  itemView.findViewById(R.id.nickname);
            this.level_item =  itemView.findViewById(R.id.level);
            this.intro_item =  itemView.findViewById(R.id.intro);
        }
    }


}
