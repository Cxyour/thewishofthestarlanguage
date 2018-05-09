package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FansBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class FansListAdapter extends BaseAdapter {

    private List<FansBean.DataBean.ListBean> listBeans;


    public FansListAdapter(List<FansBean.DataBean.ListBean> listBeans) {

        this.listBeans = listBeans;
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = App.context.getLayoutInflater().inflate(R.layout.follow_item, parent, false);
            holder.follow_item_img = convertView.findViewById(R.id.follow_item_img);
            holder.follow_item_btn = convertView.findViewById(R.id.follow_item_btn);
            holder.follow_item_nickname = convertView.findViewById(R.id.follow_item_nickname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ViewHolder finalHolder = holder;
        holder.follow_item_btn.setText("相互关注");
        holder.follow_item_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    finalHolder.follow_item_btn.setText("已关注");
                    finalHolder.follow_item_btn.setBackgroundColor(Color.parseColor("#ffffff"));
                } else {
                    finalHolder.follow_item_btn.setText("关注");
                    finalHolder.follow_item_btn.setBackgroundColor(Color.parseColor("#0000ff"));
                }
            }
        });
        Glide.with(App.context).load(listBeans.get(position).getPhoto()).asBitmap().into(new ImageViewTarget<Bitmap>(finalHolder.follow_item_img) {
            @Override
            protected void setResource(Bitmap bitmap) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(App.context.getResources(), bitmap);
                drawable.setCircular(true);
                finalHolder.follow_item_img.setBackground(drawable);
            }
        });
        holder.follow_item_nickname.setText(listBeans.get(position).getNickname());
        return convertView;
    }

    class ViewHolder {
        public ImageView follow_item_img;
        public CheckBox follow_item_btn;
        public TextView follow_item_nickname;

    }

}
