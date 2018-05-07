package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment;

import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IFamousTeacherContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.FamousTeacherPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.FamousTecherAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamousTeacherFragment extends BaseFragment implements IFamousTeacherContract.IFamousTeacherView {
    private PullLoadMoreRecyclerView pullLoadMoreRecyclerView;

    private ArrayList<Object> mRecycleaArray;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_famous_teacher;
    }

    @Override
    protected void init(View view) {

        FamousTeacherPresenterImp famousTeacherPresenter = new FamousTeacherPresenterImp(this);
        Map<String, String> params = new HashMap<>();
        famousTeacherPresenter.loadFrmousBean();
        mRecycleaArray = new ArrayList<>();
        pullLoadMoreRecyclerView = view.findViewById(R.id.teacher_recycle);
        pullLoadMoreRecyclerView.setLinearLayout();
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {

            }
        });

    }

    @Override
    protected void loadData() {

    }


    @Override
    public void showFamousTecah(FamousTeacherBean famousTeacherBean) {
        FamousTeacherBean.DataBean data = famousTeacherBean.getData();
        List<FamousTeacherBean.DataBean.SystemAdsBean> systemAds = data.getSystemAds();
        mRecycleaArray.add(systemAds);
        List<FamousTeacherBean.DataBean.UsersBean> users = data.getUsers();
        mRecycleaArray.add(users);
        List<FamousTeacherBean.DataBean.LiveCoursesBean> liveCourses = data.getLiveCourses();
        mRecycleaArray.add(liveCourses);
        List<FamousTeacherBean.DataBean.HomewoksBean> homewoks = data.getHomewoks();
        mRecycleaArray.add(homewoks);
        FamousTecherAdapter famousTecherAdapter = new FamousTecherAdapter(data);
        pullLoadMoreRecyclerView.setAdapter(famousTecherAdapter);
    }
}
