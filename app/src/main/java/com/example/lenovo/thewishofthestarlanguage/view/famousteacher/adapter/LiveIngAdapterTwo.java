package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LivePurchaseBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class LiveIngAdapterTwo extends RecyclerView.Adapter<LiveIngAdapterTwo.Holder> {

    LivePurchaseBean.DataBean data;
    Context context;
    int index;

    public LiveIngAdapterTwo(LivePurchaseBean.DataBean data, int index) {
        this.data = data;
        this.index = index;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.live_item2, parent,false);
        return new Holder(inflate);
    }

    private  void guanzhu(final Holder holder){
        SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        final int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
        holder.guan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    holder.guan.setText("已关注");

                    RetrofitUtils.getInstance().getFollowService().follow(data.getId(),xyxy_user_id)
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
                    holder.guan.setText("关注");
                    RetrofitUtils.getInstance().getFollowService().abolishConcern(data.getId(),xyxy_user_id)
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
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {

        Glide.with(context).load(data.getCoverImg()).into(holder.coverImg);
        holder.realname.setText(data.getRealname());
        holder.isSubscribe.setText("已预约:"+data.getIsSubscribe()+"/"+data.getSubscribeNum());
        holder.replay.setText("￥"+data.getReplay());
        Date date = new Date(data.getStartDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
        String format = simpleDateFormat.format(date);
        holder.startDate.setText("开课时间:  "+format);
        Glide.with(context).load(data.getPhoto()).asBitmap().into(new BitmapImageViewTarget(holder.photo){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                holder.photo.setImageDrawable(roundedBitmapDrawable);
            }
        });
        holder.type.setText(data.getIntro());
        WebSettings webSettings = holder.live_webview.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        holder.live_webview.setWebViewClient(new WebViewClient());
        holder.live_webview.loadUrl("http://share.univstar.com/view/live.html?id="+index);
        guanzhu(holder);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

 class Holder extends RecyclerView.ViewHolder {
        public CheckBox guan;
        public View rootView;
        public ImageView coverImg;
        public TextView startDate;
        public TextView isSubscribe;
        public TextView replay;
        public ImageView photo;
        public TextView realname;
        public ImageView vvv;
        public WebView live_webview;
        private  TextView type;
        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.coverImg = (ImageView) rootView.findViewById(R.id.coverImg);
            this.startDate = (TextView) rootView.findViewById(R.id.startDate);
            this.isSubscribe = (TextView) rootView.findViewById(R.id.isSubscribe);
            this.replay = (TextView) rootView.findViewById(R.id.replay);
            this.photo = (ImageView) rootView.findViewById(R.id.photo);
            this.realname = (TextView) rootView.findViewById(R.id.realname);
            this.vvv = (ImageView) rootView.findViewById(R.id.vvv);
            this.live_webview = (WebView) rootView.findViewById(R.id.live_webview);
            this.type=rootView.findViewById(R.id.teachettype);
            this.guan=rootView.findViewById(R.id.guan);
        }

    }
}
