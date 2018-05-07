package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class Item4TeacherAdapter extends BaseAdapter {
    List<FamousTeacherBean.DataBean.HomewoksBean> homewoks;

    public Item4TeacherAdapter(List<FamousTeacherBean.DataBean.HomewoksBean> homewoks) {
        this.homewoks = homewoks;
    }

    @Override
    public int getCount() {
        return homewoks.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item3_item1, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Glide.with(parent.getContext()).load(homewoks.get(position).getPhoto()).asBitmap()
                .into(new BitmapImageViewTarget(viewHolder.work_img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(parent.getContext().getResources(), resource);
                        roundedBitmapDrawable.setCircular(true);
                        viewHolder.work_img.setImageDrawable(roundedBitmapDrawable);
                    }
                });
        viewHolder.work_name.setText(homewoks.get(position).getNickname());
        Date date = new Date(homewoks.get(position).getCreateDate());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        viewHolder.work_time.setText(format);
        viewHolder.work_content.setText(homewoks.get(position).getContent());
        Glide.with(parent.getContext()).load(homewoks.get(position).getCoverImg()).into(viewHolder.word_image);

        return convertView;

    }

    public static class ViewHolder {
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
