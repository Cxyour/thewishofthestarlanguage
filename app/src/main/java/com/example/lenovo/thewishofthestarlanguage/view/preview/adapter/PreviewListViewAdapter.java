package com.example.lenovo.thewishofthestarlanguage.view.preview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
    int index;

    public PreviewListViewAdapter(PreviewActivityBean.DataBean data, int index) {
        this.data = data;
        this.index = index;
    }

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


        //again_NameTeacherContent.loadUrl(String.format(webUrl,id));
        //again_NameTeacherContent.setWebViewClient(new WebViewClient());
        //声明WebSettings子类
        WebSettings webSettings = viewHolder.courseContent.getSettings();
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
        viewHolder.courseContent.loadUrl(String.format("http://share.univstar.com/view/course.html?courseid=%s", index));
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public ImageView title_img;
        public TextView sj;
        public TextView dizhi;
        public TextView yuyue;
        public TextView qian;
        public WebView courseContent;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title_img = (ImageView) rootView.findViewById(R.id.title_img);
            this.sj = (TextView) rootView.findViewById(R.id.sj);
            this.dizhi = (TextView) rootView.findViewById(R.id.dizhi);
            this.yuyue = (TextView) rootView.findViewById(R.id.yuyue);
            this.qian = (TextView) rootView.findViewById(R.id.qian);
            this.courseContent = (WebView) rootView.findViewById(R.id.courseContent);
        }

    }
}
