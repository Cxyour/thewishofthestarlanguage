package com.example.lenovo.thewishofthestarlanguage.view.preview.fragment;

import android.view.View;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.PreviewContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.Preview;
import com.example.lenovo.thewishofthestarlanguage.presenter.PreviewPresenter;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.preview.adapter.PreviewAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

public class PreviewFragment extends BaseFragment implements PreviewContract.view{
    private PullLoadMoreRecyclerView preview_recycle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_preview;
    }

    @Override
    protected void init(View view) {
        preview_recycle=view.findViewById(R.id.preview_recycle);
        preview_recycle.setLinearLayout();

    }

    @Override
    protected void loadData() {
        PreviewPresenter previewPresenter = new PreviewPresenter(this);
        previewPresenter.loadPreview();
    }

    @Override
    public void showPreview(Preview preview) {
        List<Preview.DataBean.ListBean> list = preview.getData().getList();
        PreviewAdapter previewAdapter = new PreviewAdapter(list);
        preview_recycle.setAdapter(previewAdapter);
    }
}
