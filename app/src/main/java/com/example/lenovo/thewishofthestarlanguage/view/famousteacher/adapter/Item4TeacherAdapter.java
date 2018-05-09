package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.FamousTeacherPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.OperationDetailsActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public class Item4TeacherAdapter extends RecyclerView.Adapter<Item4TeacherAdapter.ViewHolder> {
    List<FamousTeacherBean.DataBean.HomewoksBean> homewoks;
    Context context;
    FamousTeacherPresenterImp famousTeacherPresenter;

    public Item4TeacherAdapter(List<FamousTeacherBean.DataBean.HomewoksBean> homewoks, FamousTeacherPresenterImp famousTeacherPresenter) {
        this.homewoks = homewoks;
        this.famousTeacherPresenter = famousTeacherPresenter;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item3_item1, null);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Glide.with(context).load(homewoks.get(position).getPhoto()).asBitmap()
                .into(new BitmapImageViewTarget(holder.work_img) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        roundedBitmapDrawable.setCircular(true);
                        holder.work_img.setImageDrawable(roundedBitmapDrawable);
                    }
                });
        holder.work_name.setText(homewoks.get(position).getNickname());
        Date date = new Date(homewoks.get(position).getCreateDate());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.work_time.setText(format);
        holder.work_content.setText(homewoks.get(position).getContent());
        Glide.with(context).load(homewoks.get(position).getCoverImg()).into(holder.word_image);
        final FamousTeacherBean.DataBean.HomewoksBean homewoksBean = homewoks.get(position);
        String tPhoto = (String) homewoksBean.getTPhoto();
        String tRealname = (String) homewoksBean.getTRealname();
        String tIntro = (String) homewoksBean.getTIntro();
        if (tRealname!=null){
            holder.renwu_rela.setVisibility(View.VISIBLE);
            holder.name.setText(tRealname);
            holder.daren.setText(tIntro);
            Glide.with(context).load(tPhoto).asBitmap().into(new BitmapImageViewTarget(holder.photo){
                @Override
                protected void setResource(Bitmap resource) {
                    super.setResource(resource);
                    RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    roundedBitmapDrawable.setCircular(true);
                    holder.photo.setImageDrawable(roundedBitmapDrawable);
                }
            });

        }
        holder.rootView.setTag(position);


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
   //     shoucang(holder,position);
        holder.work_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OperationDetailsActivity.class);
                intent.putExtra("id",homewoksBean.getId());
                context.startActivity(intent);
            }
        });
    }
    private void zan(final ViewHolder holder, final int position){
        holder.work_zan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences sp = context.getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                boolean isLogin = sp.getBoolean("isLogin", false);
                FamousTeacherBean.DataBean.HomewoksBean listBean = homewoks.get(position);
                int userId = listBean.getTUserId();
                int id = listBean.getId();
                String worksType = listBean.getWorksType();
                int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
                HashMap<String, String> parmas = new HashMap<>();
                parmas.put("userId", String.valueOf(userId));
                parmas.put("id", String.valueOf(id));
                parmas.put("loginUserId", String.valueOf(xyxy_user_id));
                parmas.put("type", "学生作业");
                if (isLogin==true){
                    if (isChecked==true) {
                        famousTeacherPresenter.loadGoodBean(parmas);
                        holder.work_zan.setText(listBean.getPraiseNum()+1+"");
                    }else {
                        famousTeacherPresenter.CancelthePraise(parmas);
                        holder.work_zan.setText(listBean.getPraiseNum()+"");
                    }
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }

            }
        });
    }
    private void shoucang(final ViewHolder holder, final int position){
        holder.work_comment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FamousTeacherBean.DataBean.HomewoksBean listBean = homewoks.get(position);
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
                        famousTeacherPresenter.Collection(parmas);
                        holder.work_comment.setText(listBean.getPraiseNum()+1+"");
                    }else {
                        famousTeacherPresenter.CancelTheCollection(parmas);
                        if (listBean.getPraiseNum()!=0) {
                            holder.work_comment.setText("");
                        }
                    }
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return homewoks.size();
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return homewoks.size();
    }



  class ViewHolder extends RecyclerView.ViewHolder {
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
        public ImageView photo;
        public TextView name;
        public Button toukan;
        public TextView  daren;
        private RelativeLayout renwu_rela;

        public ViewHolder(View rootView) {
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
            this.photo = (ImageView) rootView.findViewById(R.id.photo);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.toukan = (Button) rootView.findViewById(R.id.toukan);
            this.renwu_rela=rootView.findViewById(R.id.renwu_rela);
            this.daren=rootView.findViewById(R.id.daren);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    Intent intent = new Intent(context, OperationDetailsActivity.class);
                    int id = homewoks.get(tag).getId();
                    intent.putExtra("id",id);
                    context.startActivity(intent);
                }
            });
        }

    }




}
