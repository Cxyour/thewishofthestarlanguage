package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;

import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/4.
 */

public class Item3TechaerAdapter extends RecyclerView.Adapter<Item3TechaerAdapter.ViewHolder> {
    List<FamousTeacherBean.DataBean.LiveCoursesBean> liveCoursesBeans;
    Context context;
    public Item3TechaerAdapter(List<FamousTeacherBean.DataBean.LiveCoursesBean> liveCoursesBeans) {
        this.liveCoursesBeans = liveCoursesBeans;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item2_item1, parent,false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.nickname.setText(liveCoursesBeans.get(position).getNickname());
        Glide.with(context).load(liveCoursesBeans.get(position).getCoverImg()).into(holder.coverImg);
    }




    @Override
    public int getItemCount() {
        return liveCoursesBeans.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView nickname;
        public ImageView coverImg;
        public TextView biaoyan;
        public TextView startDate;
        public ImageView level;
        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.nickname = (TextView) rootView.findViewById(R.id.nickname);
            this.coverImg = (ImageView) rootView.findViewById(R.id.coverImg);
            this.biaoyan = (TextView) rootView.findViewById(R.id.biaoyan);
            this.startDate = (TextView) rootView.findViewById(R.id.startDate);
            this.level=rootView.findViewById(R.id.level);
        }

    }
}
