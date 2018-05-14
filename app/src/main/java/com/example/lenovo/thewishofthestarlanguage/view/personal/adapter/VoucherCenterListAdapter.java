package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/10.
 */

public class VoucherCenterListAdapter extends BaseAdapter {

    private List<VoucherBean.DataBean.ListBean> listBeans;

    public VoucherCenterListAdapter(List<VoucherBean.DataBean.ListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = App.context.getLayoutInflater().inflate(R.layout.voucher_list_item, parent, false);
            holder.voucher_list_item_jindou_count = convertView.findViewById(R.id.voucher_list_item_jindou_count);
            holder.voucher_list_item_jindou_price = convertView.findViewById(R.id.voucher_list_item_jindou_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.voucher_list_item_jindou_count.setText(listBeans.get(position).getAmountAndroid() + "");
        holder.voucher_list_item_jindou_price.setText("¥ " + listBeans.get(position).getPriceAndroid() + ".0");
        View inflate = LayoutInflater.from(App.context).inflate(R.layout.toukan_item, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(App.context.getLayoutInflater().inflate(R.layout.fragment_famous_teacher, null), Gravity.BOTTOM, 0, 0);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView voucher_list_item_jindou_count;
        private TextView voucher_list_item_jindou_price;
    }
}
