package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.FamousTeacherPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.FamousTeacherActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.LiveDetailsActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity.LiveingActivity;
import com.example.lenovo.thewishofthestarlanguage.view.homework.fragment.HomeWorkFragment;
import com.example.lenovo.thewishofthestarlanguage.view.preview.activity.PrevieDetailsActivity;
import com.example.lenovo.thewishofthestarlanguage.view.preview.fragment.PreviewFragment;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.fragment.TreasureFragment;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/4.
 */

public class FamousTecherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FamousTeacherPresenterImp famousTeacherPresenter;
    private final int LIVEC = 2;
    private final int HOMEWORK = 3;
    private final int SYSTEMASD = 0;
    private final int USERS = 1;
    private Context context;
    FamousTeacherBean.DataBean data;
    private FragmentManager supportFragmentManager;

    public FamousTecherAdapter(FamousTeacherPresenterImp famousTeacherPresenter, FamousTeacherBean.DataBean data, FragmentManager supportFragmentManager) {
        this.famousTeacherPresenter = famousTeacherPresenter;
        this.data = data;
        this.supportFragmentManager = supportFragmentManager;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof SYSCHolder) {
            //    List<FamousTeacherBean.DataBean.SystemAdsBean>  liveCoursesBean = (List<FamousTeacherBean.DataBean.SystemAdsBean>) mRecycleaArray.get(SYSTEMASD);

            final ArrayList<String> strings = new ArrayList<>();
            final List<FamousTeacherBean.DataBean.SystemAdsBean> systemAds = data.getSystemAds();
            for (FamousTeacherBean.DataBean.SystemAdsBean systemAd : systemAds) {
                String pcImgUrl = systemAd.getPcImgUrl();
                strings.add(pcImgUrl);
            }
            ((SYSCHolder) holder).teacher_fly.setImagesUrl(strings);
            ((SYSCHolder) holder).teacher_fly.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
                @Override
                public void onItemClick(int position1) {
                    FamousTeacherBean.DataBean.SystemAdsBean systemAdsBean = systemAds.get(position1);
                    String urlType = systemAdsBean.getUrlType();
                    String mobileUrl = systemAdsBean.getMobileUrl();
                    if (urlType.equals("3")){
                        Intent intent = new Intent(context, PrevieDetailsActivity.class);
                        intent.putExtra("id",Integer.parseInt(mobileUrl));
                        context.startActivity(intent);
                    }else {
                        Intent intent = new Intent(context, LiveDetailsActivity.class);
                        intent.putExtra("id",Integer.parseInt(mobileUrl));
                        context.startActivity(intent);
                    }
                }
            });
            ((SYSCHolder) holder).lineclass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LiveingActivity.class);
                    context.startActivity(intent);
                }
            });
            ((SYSCHolder) holder).zhaoTecher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FamousTeacherActivity.class);
                    context.startActivity(intent);
                }
            });
            ((SYSCHolder) holder).jiaowork.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.context.setContentView(R.id.home_lay, HomeWorkFragment.class);

                }
        });
            ((SYSCHolder) holder).liaoYK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.context.setContentView(R.id.home_lay, TreasureFragment.class);

                }
            });
            ((SYSCHolder) holder).xianXK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.context.setContentView(R.id.home_lay, PreviewFragment.class);
                }
            });

        }
        if (holder instanceof UserHolder) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((UserHolder) holder).teacher_list.setLayoutManager(linearLayoutManager);
            Item2TeacherAdapter item2TeacherAdapter = new Item2TeacherAdapter(data.getUsers());
            ((UserHolder) holder).teacher_list.setAdapter(item2TeacherAdapter);
            ((UserHolder) holder).gengduo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FamousTeacherActivity.class);
                    context.startActivity(intent);
                }
            });

        }
        if (holder instanceof LIVECHolder) {
            Item3TechaerAdapter item3TechaerAdapter = new Item3TechaerAdapter(data.getLiveCourses());
            ((LIVECHolder) holder).kecheng_grid.setLayoutManager(new GridLayoutManager(context, 2));
            ((LIVECHolder) holder).kecheng_grid.setAdapter(item3TechaerAdapter);
            ((LIVECHolder) holder).gengduo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LiveingActivity.class);
                    context.startActivity(intent);
                }
            });

        }
        if (holder instanceof HomeWorkHolder){
            List<FamousTeacherBean.DataBean.HomewoksBean> homewoks = data.getHomewoks();
           // ScrollDisabledListView scrollDisabledListView = new ScrollDisabledListView(context);
            ((HomeWorkHolder) holder).work_recycle.setLayoutManager(new LinearLayoutManager(context));
            Item4TeacherAdapter item4TeacherAdapter = new Item4TeacherAdapter(homewoks,famousTeacherPresenter);
            ((HomeWorkHolder) holder).work_recycle.setAdapter(item4TeacherAdapter);
            ((HomeWorkHolder) holder).gengduo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // App.context.setContentView(R.id.home_lay, HomeWorkFragment.class, null);
                    FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.home_lay, new HomeWorkFragment());
                    transaction.commit();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

     class SYSCHolder extends RecyclerView.ViewHolder {
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

   class UserHolder extends RecyclerView.ViewHolder {
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

    class LIVECHolder extends RecyclerView.ViewHolder {
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

  class HomeWorkHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView gengduo;
        public RecyclerView work_recycle;

        public HomeWorkHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gengduo = (TextView) rootView.findViewById(R.id.gengduo);
            this.work_recycle = (RecyclerView) rootView.findViewById(R.id.work_recycle);

        }

    }
}
