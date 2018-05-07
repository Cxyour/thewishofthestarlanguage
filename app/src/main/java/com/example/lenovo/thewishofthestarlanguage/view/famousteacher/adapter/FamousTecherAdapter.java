package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/4.
 */

public class FamousTecherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int LIVEC = 2;
    private final int HOMEWORK = 3;
    private final int SYSTEMASD = 0;
    private final int USERS = 1;
    private Context context;
    FamousTeacherBean.DataBean data;

    public FamousTecherAdapter(FamousTeacherBean.DataBean data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder = null;
        if (viewType == 0) {

            View teacher_item0 = layoutInflater.inflate(R.layout.teacher_item0, parent, false);
            holder = new SYSCHolder(teacher_item0);
        } else if (viewType == 1) {
            View techer_item1 = layoutInflater.inflate(R.layout.techer_item1, parent, false);
            holder = new UserHolder(techer_item1);

        } else if (viewType == 2) {
            View teacher_item2 = layoutInflater.inflate(R.layout.teacher_item2, parent, false);
            holder = new LIVECHolder(teacher_item2);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.teacher_item3, parent, false);
            holder=new HomeWorkHolder(inflate);

            return holder;
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else {
            return 3;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SYSCHolder) {
            //    List<FamousTeacherBean.DataBean.SystemAdsBean>  liveCoursesBean = (List<FamousTeacherBean.DataBean.SystemAdsBean>) mRecycleaArray.get(SYSTEMASD);

            ArrayList<String> strings = new ArrayList<>();
            List<FamousTeacherBean.DataBean.SystemAdsBean> systemAds = data.getSystemAds();
            for (FamousTeacherBean.DataBean.SystemAdsBean systemAd : systemAds) {
                String pcImgUrl = systemAd.getPcImgUrl();
                strings.add(pcImgUrl);
            }

            ((SYSCHolder) holder).teacher_fly.setImagesUrl(strings);
        }
        if (holder instanceof UserHolder) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((UserHolder) holder).teacher_list.setLayoutManager(linearLayoutManager);
            Item2TeacherAdapter item2TeacherAdapter = new Item2TeacherAdapter(data.getUsers());
            ((UserHolder) holder).teacher_list.setAdapter(item2TeacherAdapter);

        }
        if (holder instanceof LIVECHolder) {
            Item3TechaerAdapter item3TechaerAdapter = new Item3TechaerAdapter(data.getLiveCourses());
            ((LIVECHolder) holder).kecheng_grid.setLayoutManager(new GridLayoutManager(context, 2));
            ((LIVECHolder) holder).kecheng_grid.setAdapter(item3TechaerAdapter);
        }
        if (holder instanceof HomeWorkHolder){
            List<FamousTeacherBean.DataBean.HomewoksBean> homewoks = data.getHomewoks();
            Item4TeacherAdapter item4TeacherAdapter = new Item4TeacherAdapter(homewoks);
            ((HomeWorkHolder) holder).work_recycle.setAdapter(item4TeacherAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class SYSCHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public FlyBanner teacher_fly;
        public TextView zhaoTecher;
        public TextView lineclass;
        public TextView jiaowork;
        public TextView liaoYK;
        public TextView xianXK;

        public SYSCHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.teacher_fly = (FlyBanner) rootView.findViewById(R.id.teacher_fly);
            this.zhaoTecher = (TextView) rootView.findViewById(R.id.zhaoTecher);
            this.lineclass = (TextView) rootView.findViewById(R.id.lineclass);
            this.jiaowork = (TextView) rootView.findViewById(R.id.jiaowork);
            this.liaoYK = (TextView) rootView.findViewById(R.id.liaoYK);
            this.xianXK = (TextView) rootView.findViewById(R.id.xianXK);
        }

    }

    public static class UserHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView gengduo;
        public RecyclerView teacher_list;

        public UserHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gengduo = rootView.findViewById(R.id.gengduo);
            this.teacher_list = rootView.findViewById(R.id.teacher_list);
        }

    }

    public static class LIVECHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView gengduo;
        public RecyclerView kecheng_grid;

        public LIVECHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gengduo = (TextView) rootView.findViewById(R.id.gengduo);
            this.kecheng_grid = (RecyclerView) rootView.findViewById(R.id.kecheng_grid);
        }

    }

    public static class HomeWorkHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView gengduo;
        public ListView work_recycle;

        public HomeWorkHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gengduo = (TextView) rootView.findViewById(R.id.gengduo);
            this.work_recycle = (ListView) rootView.findViewById(R.id.work_recycle);
        }

    }
}
