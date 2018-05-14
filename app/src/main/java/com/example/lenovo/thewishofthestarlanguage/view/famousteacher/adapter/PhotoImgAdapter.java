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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;

import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/13.
 */

public class PhotoImgAdapter extends RecyclerView.Adapter<PhotoImgAdapter.Holer> {

        List<OperationBean.DataBean.RewardUserListBean> mlist;
        Context context;


    public PhotoImgAdapter(List<OperationBean.DataBean.RewardUserListBean> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public Holer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.photo_img, parent, false);
        return new Holer(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final Holer holder, int position) {
        Glide.with(context).load(mlist.get(position).getUserPhoto()).asBitmap()
                .into(new BitmapImageViewTarget(holder.imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        roundedBitmapDrawable.setCircular(true);
                        holder.imageView.setImageDrawable(roundedBitmapDrawable);
                    }
                });

    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class Holer extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public Holer(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
        }
    }
}
