package com.example.lenovo.thewishofthestarlanguage.view.homework.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.MostEavePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.OperationDetailsActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public class MostEavedroppingAdapter extends RecyclerView.Adapter<MostEavedroppingAdapter.Holder> {
    List<MostEavesdeoppBean.DataBean.ListBean> list;
    Context context;
    MostEavePresenterImp mostEavePresenter;

    public MostEavedroppingAdapter(List<MostEavesdeoppBean.DataBean.ListBean> list, MostEavePresenterImp mostEavePresenter) {
        this.list = list;
        this.mostEavePresenter = mostEavePresenter;
    }

    public MostEavedroppingAdapter(List<MostEavesdeoppBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item3_item1, null);
        Holder viewHolder = new Holder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.rootView.setTag(position);
        Glide.with(context).load(list.get(position).getCoverImg()).asBitmap().into(new BitmapImageViewTarget(holder.work_img){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                holder.work_img.setImageDrawable(roundedBitmapDrawable);
            }
        });
        holder.work_name.setText(list.get(position).getNickname());
        Date date = new Date(list.get(position).getCreateDate());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.work_time.setText(format);
        holder.work_content.setText(list.get(position).getContent());
        Glide.with(context).load(list.get(position).getCoverImg()).into(holder.word_image);
        final MostEavesdeoppBean.DataBean.ListBean homewoksBean = list.get(position);

        if (homewoksBean.getGiftNum()==0) {
            holder.work_shang.setText("");
        }else {
            holder.work_shang.setText(homewoksBean.getGiftNum() + "");
        }
        if (homewoksBean.getPraiseNum()!=0)
            holder.work_zan.setText(homewoksBean.getPraiseNum()+"");
        else
            holder.work_zan.setText("");
        int commentNum = homewoksBean.getCommentNum();
        if (commentNum==0){
            holder.work_comment.setText("");
        }else {
            holder.work_comment.setText(""+commentNum);
        }
        zan(holder,position);

        holder.work_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OperationDetailsActivity.class);
                intent.putExtra("id",homewoksBean.getId());
                context.startActivity(intent);
            }
        });
       // shoucang(holder,position);


    }
    private void zan(final Holder holder, final int position){
        holder.work_zan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                boolean isLogin = sp.getBoolean("isLogin", false);
                MostEavesdeoppBean.DataBean.ListBean listBean = list.get(position);
                int userId = listBean.getTUserId();
                int id = listBean.getId();
                String worksType = listBean.getWorksType();
                int xyxy_user_id = sp.getInt("user_id", 0);
                HashMap<String, String> parmas = new HashMap<>();
                parmas.put("userId", String.valueOf(userId));
                parmas.put("id", String.valueOf(id));
                parmas.put("loginUserId", String.valueOf(xyxy_user_id));
                parmas.put("type", "学生作业");
                if (isLogin==true){
                    if (isChecked==true) {

                        mostEavePresenter.loadGoodBean(parmas);
                        holder.work_zan.setText(listBean.getPraiseNum()+1+"");
                    }else {
                        mostEavePresenter.CancelthePraise(parmas);
                        holder.work_zan.setText(listBean.getPraiseNum()+"");
                    }
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }

            }
        });
    }
    private void shoucang(final Holder holder, final int position){
        holder.work_comment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MostEavesdeoppBean.DataBean.ListBean listBean = list.get(position);
                int id = listBean.getId();
                SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                boolean isLogin = sp.getBoolean("isLogin", false);
                int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
                HashMap<String, String> parmas = new HashMap<>();
                parmas.put("id", String.valueOf(id));
                parmas.put("loginUserId", String.valueOf(xyxy_user_id));
                parmas.put("type", "艺考圈作品");
                if (isLogin==true){
                    if (isChecked==true) {
                        mostEavePresenter.Collection(parmas);
                        holder.work_comment.setText(listBean.getPraiseNum()+1+"");
                    }else {
                        mostEavePresenter.CancelTheCollection(parmas);
                        if (listBean.getPraiseNum()!=0) {
                            holder.work_comment.setText("");
                        }
                    }
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                //    intent.putExtra("id",)
                    context.startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }



class Holder extends RecyclerView.ViewHolder {
    public View rootView;
    public ImageView work_img;
    public TextView work_name;
    public TextView work_time;
    public TextView laizi;
    public TextView work_from;
    public TextView work_content;
    public ImageView word_image;
    public CheckBox work_comment;
    public CheckBox work_zan;
    public CheckBox work_shang;
    public CheckBox work_share;

    public Holder(View rootView) {
        super(rootView);
        this.rootView = rootView;
        this.work_img = (ImageView) rootView.findViewById(R.id.work_img);
        this.work_name = (TextView) rootView.findViewById(R.id.work_name);
        this.work_time = (TextView) rootView.findViewById(R.id.work_time);
        this.laizi = (TextView) rootView.findViewById(R.id.laizi);
        this.work_from = (TextView) rootView.findViewById(R.id.work_from);
        this.work_content = (TextView) rootView.findViewById(R.id.work_content);
        this.word_image = (ImageView) rootView.findViewById(R.id.word_image);
        this.work_comment = (CheckBox) rootView.findViewById(R.id.work_comment);
        this.work_zan = (CheckBox) rootView.findViewById(R.id.work_zan);
        this.work_shang = (CheckBox) rootView.findViewById(R.id.work_shang);
        this.work_share = (CheckBox) rootView.findViewById(R.id.work_share);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) v.getTag();
                Intent intent = new Intent(context, OperationDetailsActivity.class);
                int id = list.get(tag).getId();
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });
    }


}

}
