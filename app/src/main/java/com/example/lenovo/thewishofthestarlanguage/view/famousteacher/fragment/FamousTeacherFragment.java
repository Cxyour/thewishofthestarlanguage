package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.fragment;

import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;

public class FamousTeacherFragment extends BaseFragment {

 //   private PullToRefreshRecyclerView famous_recycle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_famous_teacher;
    }

    @Override
    protected void init(View view) {
          /*  famous_recycle=getView().findViewById(R.id.famous_recycle);
            famous_recycle.setLayoutManager(new LinearLayoutManager(getContext()));
            famous_recycle.setPullRefreshEnabled(true);
            famous_recycle.setLoadingMoreEnabled(true);*/
    }

    @Override
    protected void loadData() {

    }


}
