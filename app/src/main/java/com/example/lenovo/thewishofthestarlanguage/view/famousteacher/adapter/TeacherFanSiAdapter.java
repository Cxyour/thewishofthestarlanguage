package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TeacherFenSi;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public class TeacherFanSiAdapter extends RecyclerView.Adapter<TeacherFanSiAdapter.Holder> {
    List<TeacherFenSi.DataBean.ListBean> list;
    private Context context;

    public TeacherFanSiAdapter(List<TeacherFenSi.DataBean.ListBean> list, int index) {
        this.list = list;
        this.index = index;
    }

    int index;
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.follow_item, parent, false);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        holder.follow_item_btn.setText("关注");
        holder.follow_item_btn.setBackgroundColor(Color.parseColor("#FF467DF5"));
        holder.follow_item_btn.setTextColor(Color.parseColor("#FFFFFF"));
        holder.follow_item_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
            boolean isLogin = sp.getBoolean("isLogin", false);
            final int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    holder.follow_item_btn.setText("已关注");

                    RetrofitUtils.getInstance().getFollowService().follow(index, xyxy_user_id)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<SaveBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                    Log.e("-------------------", d.toString());
                                }

                                @Override
                                public void onNext(SaveBean saveBean) {
                                    Log.e("-------------------", saveBean.getMessage());
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.e("-------------------", e.getMessage().toString());
                                }

                                @Override
                                public void onComplete() {

                                }
                            });

                } else {
                    holder.follow_item_btn.setText("关注");
                    RetrofitUtils.getInstance().getFollowService().abolishConcern(index, xyxy_user_id)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<SaveBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                    Log.e("-------------------", d.toString());
                                }

                                @Override
                                public void onNext(SaveBean saveBean) {
                                    Log.e("-------------------", saveBean.getMessage());

                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.e("-------------------", e.getMessage().toString());
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        });
        String photo = list.get(position).getPhoto();
        Glide.with(context).load(photo).asBitmap().into(new ImageViewTarget<Bitmap>(holder.follow_item_img) {
            @Override
            protected void setResource(Bitmap bitmap) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
                drawable.setCircular(true);
                holder.follow_item_img.setBackground(drawable);
            }
        });
        holder.follow_item_nickname.setText(list.get(position).getNickname());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }



  class Holder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView follow_item_img;
        public CheckBox follow_item_btn;
        public TextView follow_item_nickname;

        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.follow_item_img = (ImageView) rootView.findViewById(R.id.follow_item_img);
            this.follow_item_btn = (CheckBox) rootView.findViewById(R.id.follow_item_btn);
            this.follow_item_nickname = (TextView) rootView.findViewById(R.id.follow_item_nickname);
        }

    }
}
