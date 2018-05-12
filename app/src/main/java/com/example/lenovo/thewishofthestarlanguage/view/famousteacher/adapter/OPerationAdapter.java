package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.OperationPresenterImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public class OPerationAdapter extends RecyclerView.Adapter<OPerationAdapter.ViewHolder> {
    OperationBean.DataBean data;
    Context context;
    OperationPresenterImp operationPresenterImp;
    String refId;
    int idd;
    public OPerationAdapter(OperationBean.DataBean data, OperationPresenterImp operationPresenterImp, String refId, int id) {
        this.data = data;
        this.operationPresenterImp = operationPresenterImp;
        this.idd=id;
        this.refId=refId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.operation_item1, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        OperationBean.DataBean.HomewokBean homewoks = data.getHomewok();
        OperationBean.DataBean.CommentsBean comments = data.getComments();
        List<OperationBean.DataBean.CommentsBean.ListBean> list = comments.getList();
        if (list.size()!=0){
            holder.shafa.setVisibility(View.GONE);
            OPerationItemAdapter oPerationItemAdapter = new OPerationItemAdapter(list,operationPresenterImp,homewoks.getId(),refId);
            holder.opera_item1_recycle.setLayoutManager(new LinearLayoutManager(context));
            holder.opera_item1_recycle.setAdapter(oPerationItemAdapter);
        }else {
            holder.shafa.setVisibility(View.VISIBLE);
        }

        Glide.with(context).load(homewoks.getPhoto()).asBitmap()
                .into(new BitmapImageViewTarget(holder.work_img) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        roundedBitmapDrawable.setCircular(true);
                        holder.work_img.setImageDrawable(roundedBitmapDrawable);
                    }
                });
        holder.work_name.setText(homewoks.getNickname());
        Date date = new Date(homewoks.getCreateDate());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.work_time.setText(format);
        holder.work_content.setText(homewoks.getContent());
        Glide.with(context).load(homewoks.getCoverImg()).into(holder.word_image);

        String tPhoto = (String) homewoks.getTPhoto();
        String tRealname = (String) homewoks.getTRealname();
        String tIntro = (String) homewoks.getTIntro();
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
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 1;
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
        public ImageView photo;
        public TextView name;
        public TextView daren;
        public Button toukan;
        public RelativeLayout renwu_rela;
        public View vieww;
        public TextView wok_detail_aty_dashang;
        public LinearLayout chieck_layout;
        public RecyclerView opera_item1_recycle;
        private LinearLayout shafa;
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
            this.photo = (ImageView) rootView.findViewById(R.id.photo);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.daren = (TextView) rootView.findViewById(R.id.daren);
            this.toukan = (Button) rootView.findViewById(R.id.toukan);
            this.renwu_rela = (RelativeLayout) rootView.findViewById(R.id.renwu_rela);
            this.vieww = (View) rootView.findViewById(R.id.vieww);
            this.wok_detail_aty_dashang = (TextView) rootView.findViewById(R.id.wok_detail_aty_dashang);
            this.chieck_layout = (LinearLayout) rootView.findViewById(R.id.chieck_layout);
            this.opera_item1_recycle = (RecyclerView) rootView.findViewById(R.id.opera_item1_recycle);
            this.shafa=rootView.findViewById(R.id.shafa);
        }

    }
}
