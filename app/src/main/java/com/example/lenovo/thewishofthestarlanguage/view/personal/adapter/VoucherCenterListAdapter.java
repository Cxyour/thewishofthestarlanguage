package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        return convertView;
    }

    class ViewHolder {
        private TextView voucher_list_item_jindou_count;
        private TextView voucher_list_item_jindou_price;
    }
}
