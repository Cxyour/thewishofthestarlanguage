package com.example.lenovo.thewishofthestarlanguage.view.preview.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupWindow;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.PreviewContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.Preview;
import com.example.lenovo.thewishofthestarlanguage.presenter.PreviewPresenter;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.preview.adapter.PreviewAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

/**
 *
 */
public class PreviewFragment extends BaseFragment implements PreviewContract.view {
    private PullLoadMoreRecyclerView preview_recycle;
    private CheckBox preview_cb_time_screen;
    private View inflate;
    private PopupWindow popupWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_preview;
    }

    @Override
    protected void init(View view) {
        preview_recycle = view.findViewById(R.id.preview_recycle);
        preview_cb_time_screen = view.findViewById(R.id.preview_cb_time_screen);
        inflate = getLayoutInflater().inflate(R.layout.popup_item, null);
        preview_cb_time_screen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    preview_cb_time_screen.setText("取消");
                    popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                    popupWindow.showAsDropDown(preview_cb_time_screen, 0, 0);
                } else {
                    preview_cb_time_screen.setText("时间筛选");
                    popupWindow.dismiss();
                }

            }
        });
        preview_recycle.setLinearLayout();
        preview_recycle.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                preview_recycle.setPullLoadMoreCompleted();

            }

            @Override
            public void onLoadMore() {
                preview_recycle.setPullLoadMoreCompleted();
            }
        });

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
