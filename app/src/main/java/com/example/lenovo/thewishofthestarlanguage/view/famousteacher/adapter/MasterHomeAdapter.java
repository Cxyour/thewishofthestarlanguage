package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterHomeBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;
import com.example.lenovo.thewishofthestarlanguage.presenter.MoasterHomePresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.CurriculumActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.TaskActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.TeachersfanSiActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class MasterHomeAdapter extends RecyclerView.Adapter<MasterHomeAdapter.Holder> {
    MasterHomeBean.DataBean dataBean;
    Context context;
    MoasterHomePresenterImp moasterHomePresenterImp;

    public MasterHomeAdapter(MasterHomeBean.DataBean dataBean, MoasterHomePresenterImp moasterHomePresenterImp) {
        this.dataBean = dataBean;
        this.moasterHomePresenterImp = moasterHomePresenterImp;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.masterhome_item, parent, false);

        return new Holder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final MasterHomeBean.DataBean.UserBean user = dataBean.getUser();
      //  holder.details.setText(user.getDetails());
        Glide.with(context).load(user.getImages()).into(holder.images);
        holder.realname.setText(user.getRealname());
        Glide.with(context).load(user.getPhoto()).asBitmap().into(new BitmapImageViewTarget(holder.photo){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                holder.photo.setImageDrawable(roundedBitmapDrawable);
            }
        });
        holder.skilled.setText(user.getSkilled());
       holder.kecheng_sl.setText(dataBean.getLiveCount()+"");
       holder.zuoye_sl.setText(dataBean.getHomewokPublishCount()+"");
       holder.fudao_sl.setText(dataBean.getCoachingCount()+"");
       holder.tiezi_sj.setText(dataBean.getAttentionCount()+"");
       holder.guanzhu_sl.setText(dataBean.getPostsCount()+"");
       holder.fensi_sl.setText(dataBean.getFansCount()+"");
       holder.details.setText(user.getDetails());
        final int id = user.getId();
        final String nickname = user.getNickname();
        holder.zuoye.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(context, TaskActivity.class);
               intent.putExtra("nickname",nickname+"的作业");
               intent.putExtra("id",id);
               context.startActivity(intent);
           }
       });
       holder.kecheng.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, CurriculumActivity.class);
               intent.putExtra("id",id);
               intent.putExtra("nickname",nickname);
               context.startActivity(intent);
           }
       });
        holder.fensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TeachersfanSiActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("nickname",nickname);
                context.startActivity(intent);
            }
        });
        holder.fudao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TaskActivity.class);
                intent.putExtra("nickname",nickname+"的辅导");
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
        holder.tiezi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TaskActivity.class);
                intent.putExtra("nickname",nickname+"的帖子");
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
        holder.guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TaskActivity.class);
                intent.putExtra("nickname",nickname+"的关注");
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });

       zan(holder,position);
        guanzhu(holder);

        holder.teachettype.setText( dataBean.getUser().getIntro());
    }
    private  void guanzhu(final Holder holder){
        SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        final int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    holder.checkBox.setText("已关注");

                    RetrofitUtils.getInstance().getFollowService().follow(dataBean.getUser().getId(),xyxy_user_id)
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
                    holder.checkBox.setText("关注");
                    RetrofitUtils.getInstance().getFollowService().abolishConcern(dataBean.getUser().getId(),xyxy_user_id)
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
    private void zan(final Holder holder, final int position){
        holder.work_zan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                boolean isLogin = sp.getBoolean("isLogin", false);
                int userId = dataBean.getUser().getId();
                int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
                HashMap<String, String> parmas = new HashMap<>();
                parmas.put("userId", String.valueOf(userId));
                parmas.put("id", String.valueOf(userId));
                parmas.put("loginUserId", String.valueOf(xyxy_user_id));
                parmas.put("type", "老师");
                if (isLogin==true){
                    if (isChecked==true) {
                        moasterHomePresenterImp.loadGoodBean(parmas);
                        holder.work_zan.setText(dataBean.getPraise().getPraiseCount()+1+"");
                    }else {
                        moasterHomePresenterImp.CancelthePraise(parmas);
                        holder.work_zan.setText(dataBean.getPraise().getPraiseCount()+"");
                    }
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return 1;
    }


    class Holder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView images;
        public TextView skilled;
        public CheckBox work_zan;
        public ImageView photo;
        public TextView realname;
        public ImageView vvv;
        public TextView teachettype;
        public TextView kecheng_sl;
        public LinearLayout kecheng;
        public TextView zuoye_sl;
        public LinearLayout zuoye;
        public TextView fudao_sl;
        public LinearLayout fudao;
        public TextView tiezi_sj;
        public LinearLayout tiezi;
        public TextView guanzhu_sl;
        public LinearLayout guanzhu;
        public TextView fensi_sl;
        public LinearLayout fensi;
        public TextView details;
        public CheckBox checkBox;
        public Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.images = (ImageView) rootView.findViewById(R.id.images);
            this.skilled = (TextView) rootView.findViewById(R.id.skilled);
            this.work_zan = (CheckBox) rootView.findViewById(R.id.work_zan);
            this.photo = (ImageView) rootView.findViewById(R.id.photo);
            this.realname = (TextView) rootView.findViewById(R.id.realname);
            this.vvv = (ImageView) rootView.findViewById(R.id.vvv);
            this.teachettype = (TextView) rootView.findViewById(R.id.teachettype);
            this.kecheng_sl = (TextView) rootView.findViewById(R.id.kecheng_sl);
            this.kecheng = (LinearLayout) rootView.findViewById(R.id.kecheng);
            this.zuoye_sl = (TextView) rootView.findViewById(R.id.zuoye_sl);
            this.zuoye = (LinearLayout) rootView.findViewById(R.id.zuoye);
            this.fudao_sl = (TextView) rootView.findViewById(R.id.fudao_sl);
            this.fudao = (LinearLayout) rootView.findViewById(R.id.fudao);
            this.tiezi_sj = (TextView) rootView.findViewById(R.id.tiezi_sj);
            this.tiezi = (LinearLayout) rootView.findViewById(R.id.tiezi);
            this.guanzhu_sl =  rootView.findViewById(R.id.guanzhu_sl);
            this.guanzhu = (LinearLayout) rootView.findViewById(R.id.guanzhu);
            this.fensi_sl = (TextView) rootView.findViewById(R.id.fensi_sl);
            this.fensi = (LinearLayout) rootView.findViewById(R.id.fensi);
            this.details = (TextView) rootView.findViewById(R.id.details);
            this.checkBox=rootView.findViewById(R.id.guan);
        }

    }
}
