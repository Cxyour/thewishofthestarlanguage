package com.example.lenovo.thewishofthestarlanguage.view.treasure.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreasurteActiviyBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class TreasureListViewAdapter extends BaseAdapter {
    TreasurteActiviyBean.DataBean.ArtcircleBean artcircle;
    Context context;

    public TreasureListViewAdapter(TreasurteActiviyBean.DataBean.ArtcircleBean artcircle) {
        this.artcircle = artcircle;
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
        final ViewHolder viewHolder;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.details_item1, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }

        viewHolder.content.setText(artcircle.getContent());
        viewHolder.contentType.setText(artcircle.getContentType());
        Glide.with(context).load(artcircle.getPhoto()).asBitmap().into(new BitmapImageViewTarget(viewHolder.photop){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                viewHolder.photop.setImageDrawable(roundedBitmapDrawable);

            }
        });
        Date date = new Date(artcircle.getCreateDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        viewHolder.createDate.setText(format);
        Glide.with(context).load(artcircle.getCoverImg()).into(viewHolder.coverImg);
        viewHolder.content.setText(artcircle.getContent());
        return convertView;
    }

    public  class ViewHolder {
        public View rootView;
        public ImageView photop;
        public TextView nickname;
        public TextView createDate;
        public TextView contentType;
        public TextView title;
        public TextView content;
        public ImageView coverImg;
        public View view2;
        public Button zhanshang;
        public RelativeLayout but_rela;
        public View view3;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.photop = (ImageView) rootView.findViewById(R.id.photop);
            this.nickname = (TextView) rootView.findViewById(R.id.nickname);
            this.createDate = (TextView) rootView.findViewById(R.id.createDate);
            this.contentType = (TextView) rootView.findViewById(R.id.contentType);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.content = (TextView) rootView.findViewById(R.id.content);
            this.coverImg = (ImageView) rootView.findViewById(R.id.coverImg);
            this.view2 = (View) rootView.findViewById(R.id.view2);
            this.zhanshang = (Button) rootView.findViewById(R.id.zhanshang);
            this.but_rela = (RelativeLayout) rootView.findViewById(R.id.but_rela);
            this.view3 = (View) rootView.findViewById(R.id.view3);

        }

    }
}
