package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PostBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/10.
 */

public class PostListAdapter extends BaseAdapter {

    private List<PostBean.DataBean.ArtcircleListBean.ListBean> listBeans;
    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年
    private final SharedPreferences user;
    private final SharedPreferences.Editor edit;

    public PostListAdapter(List<PostBean.DataBean.ArtcircleListBean.ListBean> listBeans) {
        this.listBeans = listBeans;
        user = App.context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
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
            convertView = App.context.getLayoutInflater().inflate(R.layout.post_list_item, parent, false);
            holder.post_photo = (ImageView) convertView.findViewById(R.id.post_photo);
            holder.post_nickname = (TextView) convertView.findViewById(R.id.post_nickname);
            holder.post_createDate = (TextView) convertView.findViewById(R.id.post_createDate);
            holder.post_contentType = (TextView) convertView.findViewById(R.id.post_contentType);
            holder.post_title = (TextView) convertView.findViewById(R.id.post_title);
            holder.post_content = (TextView) convertView.findViewById(R.id.post_content);
            holder.post_coverImg = (ImageView) convertView.findViewById(R.id.post_coverImg);
            holder.post_label = (TextView) convertView.findViewById(R.id.post_label);
            holder.post_list_item_collect_cb = (CheckBox) convertView.findViewById(R.id.post_list_item_collect_cb);
            holder.post_list_item_reply_cb = (CheckBox) convertView.findViewById(R.id.post_list_item_reply_cb);
            holder.post_list_item_praise_cb = (CheckBox) convertView.findViewById(R.id.post_list_item_praise_cb);
            holder.post_list_item_share = (LinearLayout) convertView.findViewById(R.id.post_list_item_share);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ViewHolder finalHolder = holder;
        Glide.with(App.context).load(listBeans.get(position).getPhoto()).asBitmap().into(new ImageViewTarget<Bitmap>(finalHolder.post_photo) {
            @Override
            protected void setResource(Bitmap bitmap) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(App.context.getResources(), bitmap);
                drawable.setCircular(true);
                finalHolder.post_photo.setBackground(drawable);
            }
        });
        holder.post_nickname.setText(listBeans.get(position).getNickname());
        holder.post_contentType.setText(listBeans.get(position).getContentType());
        holder.post_createDate.setText(getTimeFormatText(new Date(listBeans.get(position).getCreateDate())));
        holder.post_title.setText(listBeans.get(position).getTitle());
        holder.post_content.setText(listBeans.get(position).getContent());
        if (listBeans.get(position).getCoverImg() == null) {
            holder.post_coverImg.setVisibility(View.GONE);
        } else {
            holder.post_coverImg.setVisibility(View.VISIBLE);
            Glide.with(App.context).load(listBeans.get(position).getCoverImg()).into(holder.post_coverImg);
        }
        if (listBeans.get(position).getIsFavorite() == 0) {
            holder.post_list_item_collect_cb.setChecked(false);
        } else {
            holder.post_list_item_collect_cb.setChecked(true);
        }
        if (listBeans.get(position).getIsPraise() == 0) {
            holder.post_list_item_praise_cb.setChecked(false);
        } else {
            holder.post_list_item_praise_cb.setChecked(true);
        }
        holder.post_list_item_collect_cb.setText(String.valueOf(listBeans.get(position).getFavoriteNum()));
        holder.post_list_item_praise_cb.setText(String.valueOf(listBeans.get(position).getPraiseNum()));
        holder.post_list_item_collect_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    HashMap<String, String> parmas = new HashMap<>();
                    parmas.put("id", String.valueOf(listBeans.get(position).getId()));
                    parmas.put("loginUserId", String.valueOf(user.getInt("user_id", 0)));
                    parmas.put("type", "艺考圈作品");
                    RetrofitUtils.getInstance().getTreaSureService().Collection(parmas)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<GoodOnClickBean>() {
                                @Override
                                public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                                    Toast.makeText(App.context, goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                    finalHolder.post_list_item_collect_cb.setText(String.valueOf(Integer.parseInt(finalHolder.post_list_item_collect_cb.getText().toString()) + 1));
                } else {
                    HashMap<String, String> parmas = new HashMap<>();
                    parmas.put("id", String.valueOf(listBeans.get(position).getId()));
                    parmas.put("loginUserId", String.valueOf(user.getInt("user_id", 0)));
                    parmas.put("type", "艺考圈作品");
                    RetrofitUtils.getInstance().getTreaSureService().CancelTheCollection(parmas)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<GoodOnClickBean>() {
                                @Override
                                public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                                    Toast.makeText(App.context, goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    finalHolder.post_list_item_collect_cb.setText(String.valueOf(Integer.parseInt(finalHolder.post_list_item_collect_cb.getText().toString()) - 1));
                }
            }
        });
        holder.post_list_item_reply_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        holder.post_list_item_praise_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    HashMap<String, String> parmas = new HashMap<>();
                    parmas.put("userId", String.valueOf(listBeans.get(position).getUserId()));
                    parmas.put("id", String.valueOf(listBeans.get(position).getId()));
                    parmas.put("loginUserId", String.valueOf(user.getInt("user_id", 0)));
                    parmas.put("type", "艺考圈作品");
                    RetrofitUtils.getInstance().getTreaSureService().loadGoodBean(parmas)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<GoodOnClickBean>() {
                                @Override
                                public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                                    Toast.makeText(App.context, goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    finalHolder.post_list_item_praise_cb.setText(String.valueOf(Integer.parseInt(finalHolder.post_list_item_collect_cb.getText().toString()) + 1));
                } else {
                    HashMap<String, String> parmas = new HashMap<>();
                    parmas.put("userId", String.valueOf(listBeans.get(position).getUserId()));
                    parmas.put("id", String.valueOf(listBeans.get(position).getId()));
                    parmas.put("loginUserId", String.valueOf(user.getInt("user_id", 0)));
                    parmas.put("type", "艺考圈作品");
                    RetrofitUtils.getInstance().getTreaSureService().CancelthePraise(parmas)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<GoodOnClickBean>() {
                                @Override
                                public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                                    Toast.makeText(App.context, goodOnClickBean.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    finalHolder.post_list_item_praise_cb.setText(String.valueOf(Integer.parseInt(finalHolder.post_list_item_praise_cb.getText().toString()) - 1));
                }
            }
        });
        return convertView;
    }

    class ViewHolder {
        private ImageView post_photo;
        private TextView post_nickname;
        private TextView post_createDate;
        private TextView post_contentType;
        private TextView post_title;
        private TextView post_content;
        private ImageView post_coverImg;
        private TextView post_label;
        private CheckBox post_list_item_collect_cb;
        private CheckBox post_list_item_reply_cb;
        private CheckBox post_list_item_praise_cb;
        private LinearLayout post_list_item_share;

    }

    public static String getTimeFormatText(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

}
