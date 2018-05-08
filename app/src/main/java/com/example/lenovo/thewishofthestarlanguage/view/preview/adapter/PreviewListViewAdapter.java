package com.example.lenovo.thewishofthestarlanguage.view.preview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewActivityBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class PreviewListViewAdapter extends BaseAdapter {
    PreviewActivityBean.DataBean data;
    private Context context;

    public PreviewListViewAdapter(PreviewActivityBean.DataBean data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return 1;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.previewlist_item1, null);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(data.getCoverImg()).into(viewHolder.title_img);

        Date date = new Date(data.getStartDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        String format = simpleDateFormat.format(date);
        viewHolder.sj.setText(format);
        viewHolder.dizhi.setText(data.getAddress());
        viewHolder.yuyue.setText("已预约:"+data.getReservationNum()+"/"+data.getSubscribeNum());
        viewHolder.qian.setText(data.getPrice()+"");
        viewHolder.courseContent.setText(data.getCourseContent());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView title_img;
        public TextView sj;
        public TextView dizhi;
        public TextView yuyue;
        public TextView qian;
        public TextView courseContent;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title_img = (ImageView) rootView.findViewById(R.id.title_img);
            this.sj = (TextView) rootView.findViewById(R.id.sj);
            this.dizhi = (TextView) rootView.findViewById(R.id.dizhi);
            this.yuyue = (TextView) rootView.findViewById(R.id.yuyue);
            this.qian = (TextView) rootView.findViewById(R.id.qian);
            this.courseContent = (TextView) rootView.findViewById(R.id.courseContent);
        }

    }
}
