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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public class Item4TeacherAdapter extends RecyclerView.Adapter<Item4TeacherAdapter.ViewHolder> {
    List<FamousTeacherBean.DataBean.HomewoksBean> homewoks;
    Context context;
    public Item4TeacherAdapter(List<FamousTeacherBean.DataBean.HomewoksBean> homewoks) {

        this.homewoks = homewoks;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item3_item1, null);
        context=parent.getContext();
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Glide.with(context).load(homewoks.get(position).getPhoto()).asBitmap()
                .into(new BitmapImageViewTarget(holder.work_img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        roundedBitmapDrawable.setCircular(true);
                        holder.work_img.setImageDrawable(roundedBitmapDrawable);
                    }
                });
        holder.work_name.setText(homewoks.get(position).getNickname());
        Date date = new Date(homewoks.get(position).getCreateDate());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.work_time.setText(format);
        holder.work_content.setText(homewoks.get(position).getContent());
        Glide.with(context).load(homewoks.get(position).getCoverImg()).into(holder.word_image);

    }

    @Override
    public long getItemId(int position) {
        return homewoks.size();
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return homewoks.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView work_img;
        public TextView work_name;
        public TextView work_time;
        public TextView laizi;
        public TextView work_from;
        public TextView work_content;
        public ImageView word_image;
        public RadioButton work_comment;
        public RadioButton work_zan;
        public RadioButton work_shang;
        public RadioButton work_share;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.work_img = (ImageView) rootView.findViewById(R.id.work_img);
            this.work_name = (TextView) rootView.findViewById(R.id.work_name);
            this.work_time = (TextView) rootView.findViewById(R.id.work_time);
            this.laizi = (TextView) rootView.findViewById(R.id.laizi);
            this.work_from = (TextView) rootView.findViewById(R.id.work_from);
            this.work_content = (TextView) rootView.findViewById(R.id.work_content);
            this.word_image = (ImageView) rootView.findViewById(R.id.word_image);
            this.work_comment = (RadioButton) rootView.findViewById(R.id.work_comment);
            this.work_zan = (RadioButton) rootView.findViewById(R.id.work_zan);
            this.work_shang = (RadioButton) rootView.findViewById(R.id.work_shang);
            this.work_share = (RadioButton) rootView.findViewById(R.id.work_share);
        }

    }
}
