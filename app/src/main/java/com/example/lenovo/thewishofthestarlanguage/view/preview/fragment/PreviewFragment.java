package com.example.lenovo.thewishofthestarlanguage.view.preview.fragment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.PreviewContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.PreviewPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseFragment;
import com.example.lenovo.thewishofthestarlanguage.view.preview.adapter.PreviewAdapter;
import com.example.lenovo.thewishofthestarlanguage.view.ui.MainActivity;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class PreviewFragment extends BaseFragment implements PreviewContract.view {
    private PullLoadMoreRecyclerView preview_recycle;
    private CheckBox preview_cb_time_screen;
    private View inflate;
    private PopupWindow popupWindow;
    private Button popup_ok;
    private Button popup_reset;
    public TextView popup_end_time;
    public TextView popup_start_time;
    private PreviewPresenterImp previewPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_preview;
    }

    @Override
    protected void init(View view) {
        preview_recycle = view.findViewById(R.id.preview_recycle);
        preview_cb_time_screen = view.findViewById(R.id.preview_cb_time_screen);
        inflate = getLayoutInflater().inflate(R.layout.popup_item, null);
        popup_start_time = inflate.findViewById(R.id.popup_start_time);
        popup_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickDlg(popup_start_time);
            }
        });
        popup_end_time = inflate.findViewById(R.id.popup_end_time);
        popup_end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickDlg(popup_end_time);
            }
        });
        popup_reset = inflate.findViewById(R.id.popup_reset);
        popup_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_end_time.setText("");
                popup_start_time.setText("");
            }
        });
        popup_ok = inflate.findViewById(R.id.popup_ok);
        popup_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewPresenter.screenTime(popup_start_time.getText().toString(), popup_end_time.getText().toString());
                popupWindow.dismiss();
            }
        });
        preview_cb_time_screen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    preview_cb_time_screen.setText("取消");
                    popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                    popupWindow.showAsDropDown(preview_cb_time_screen, 0, 0);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            preview_cb_time_screen.setText("时间筛选");
                        }
                    });
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
        previewPresenter = new PreviewPresenterImp(this);
        previewPresenter.loadPreview();
    }

    @Override
    public void showPreview(PreviewBean preview) {
        List<PreviewBean.DataBean.ListBean> list = preview.getData().getList();
        PreviewAdapter previewAdapter = new PreviewAdapter(list);
        preview_recycle.setAdapter(previewAdapter);
    }

    protected void showDatePickDlg(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();


    }
}
