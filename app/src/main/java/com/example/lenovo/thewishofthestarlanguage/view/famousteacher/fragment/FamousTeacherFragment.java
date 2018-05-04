package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment;

import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IFamousTeacherContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.FamousTeacherPresenter;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

public class FamousTeacherFragment extends BaseFragment implements IFamousTeacherContract.IFamousTeacherView{
    private PullLoadMoreRecyclerView pullLoadMoreRecyclerView;

    //   private PullToRefreshRecyclerView famous_recycle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_famous_teacher;
    }

    @Override
    protected void init(View view) {

        FamousTeacherPresenter famousTeacherPresenter = new FamousTeacherPresenter(this);
        famousTeacherPresenter.loadFrmousBean();
        pullLoadMoreRecyclerView = view.findViewById(R.id.teacher_recycle);

    }

    @Override
    protected void loadData() {

    }

    

    @Override
    public void showFamousTecah(FamousTeacherBean famousTeacherBean) {
        FamousTeacherBean.DataBean data = famousTeacherBean.getData();
        
    }
}
