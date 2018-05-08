package com.example.lenovo.thewishofthestarlanguage.view.treasure.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.activity.TreasureDetailsActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public class TreasureAdapter extends RecyclerView.Adapter<TreasureAdapter.Holder> {
    List<TreaSureBean.DataBean.ArtcircleListBean.ListBean> list;
    Context context;

    public TreasureAdapter(List<TreaSureBean.DataBean.ArtcircleListBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.treasure_item1, parent,false);
        Holder holder = new Holder(inflate);

        return holder;
    }



    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        TreaSureBean.DataBean.ArtcircleListBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getPhoto()).asBitmap().into(new BitmapImageViewTarget(holder.photo){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                holder.photo.setImageDrawable(roundedBitmapDrawable);

            }
        });
        holder.nickname.setText(listBean.getNickname());
        holder.contentType.setText(listBean.getContentType());
        holder.title.setText(listBean.getTitle());
        holder.content.setText(listBean.getContent());
        Glide.with(context).load(listBean.getCoverImg()).into(holder.coverImg);
        Date date = new Date(listBean.getCreateDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.createDate.setText(format);
        holder.rootView.setTag(position);

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView photo;
        public TextView nickname;
        public TextView createDate;
        public TextView contentType;
        public TextView title;
        public TextView content;
        public ImageView coverImg;
        public View vivv;
        public CheckBox home_valuable_list_item_collect_cb;
        public LinearLayout home_valuable_list_item_collect_group;
        public CheckBox home_valuable_list_item_reply_cb;
        public LinearLayout home_valuable_list_item_reply_group;
        public CheckBox home_valuable_list_item_praise_cb;
        public LinearLayout home_valuable_list_item_praise_group;
        public LinearLayout home_valuable_list_item_share;
        public Holder(View itemView) {
            super(itemView);
            this.rootView = itemView;
            this.photo = (ImageView) rootView.findViewById(R.id.photop);
            this.nickname = (TextView) rootView.findViewById(R.id.nickname);
            this.createDate = (TextView) rootView.findViewById(R.id.createDate);
            this.contentType = (TextView) rootView.findViewById(R.id.contentType);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.content = (TextView) rootView.findViewById(R.id.content);
            this.coverImg = (ImageView) rootView.findViewById(R.id.coverImg);
            this.vivv = (View) rootView.findViewById(R.id.vivv);
            this.home_valuable_list_item_collect_cb = (CheckBox) rootView.findViewById(R.id.home_valuable_list_item_collect_cb);
            this.home_valuable_list_item_collect_group = (LinearLayout) rootView.findViewById(R.id.home_valuable_list_item_collect_group);
            this.home_valuable_list_item_reply_cb = (CheckBox) rootView.findViewById(R.id.home_valuable_list_item_reply_cb);
            this.home_valuable_list_item_reply_group = (LinearLayout) rootView.findViewById(R.id.home_valuable_list_item_reply_group);
            this.home_valuable_list_item_praise_cb = (CheckBox) rootView.findViewById(R.id.home_valuable_list_item_praise_cb);
            this.home_valuable_list_item_praise_group = (LinearLayout) rootView.findViewById(R.id.home_valuable_list_item_praise_group);
            this.home_valuable_list_item_share = (LinearLayout) rootView.findViewById(R.id.home_valuable_list_item_share);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    TreaSureBean.DataBean.ArtcircleListBean.ListBean listBean = list.get(tag);

                    int id = listBean.getId();
                    Intent intent = new Intent(context, TreasureDetailsActivity.class);
                    intent.putExtra("id",id);
                    context.startActivity(intent);
                }
            });
        }
    }


}
