package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FollowService;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FansBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class FansListAdapter extends BaseAdapter {

    private List<FansBean.DataBean.ListBean> listBeans;
    private final SharedPreferences user;
    private final SharedPreferences.Editor edit;
    private final FollowService followService;

    public FansListAdapter(List<FansBean.DataBean.ListBean> listBeans) {
        user = App.context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        followService = RetrofitUtils.getInstance().getFollowService();
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
                    followService.follow(listBeans.get(position).getFansId(), user.getInt("user_id", 0))
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<SaveBean>() {
                                @Override
                                public void accept(SaveBean saveBean) throws Exception {
                                    Toast.makeText(App.context, saveBean.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                } else {
                    finalHolder.follow_item_btn.setText("关注");
                    followService.abolishConcern(listBeans.get(position).getFansId(), user.getInt("user_id", 0))
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<SaveBean>() {
                                @Override
                                public void accept(SaveBean saveBean) throws Exception {
                                    Toast.makeText(App.context, saveBean.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
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
