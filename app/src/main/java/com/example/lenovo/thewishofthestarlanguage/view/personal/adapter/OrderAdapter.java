package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyOrderBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class OrderAdapter extends BaseAdapter {

    private List<MyOrderBean.DataBean.ListBean> list;

    public OrderAdapter(List<MyOrderBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView = App.context.getLayoutInflater().inflate(R.layout.order_list_item, parent, false);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            holder.item_title = (TextView) convertView.findViewById(R.id.item_title);
            holder.item_pay_status = (TextView) convertView.findViewById(R.id.item_pay_status);
            holder.item_pay_btn = (Button) convertView.findViewById(R.id.item_pay_btn);
            holder.item_img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.item_start_time = (TextView) convertView.findViewById(R.id.item_start_time);
            holder.item_price = (TextView) convertView.findViewById(R.id.item_price);
            holder.item_pay_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.item_title.setText(list.get(position).getTitle());
        Glide.with(App.context).load(list.get(position).getCoverImg()).into(holder.item_img);
        holder.item_start_time.setText("体验开播:" + new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(list.get(position).getStartDate())));
        holder.item_price.setText(list.get(position).getPrice() + ".0");
        int orderStatus = list.get(position).getOrderStatus();
        switch (orderStatus) {
            case 0:
                holder.item_pay_status.setText("待付款");
                holder.item_pay_status.setTextColor(Color.parseColor("#fcaa2f"));
                holder.item_pay_btn.setVisibility(View.VISIBLE);
                break;
            case 1:
                holder.item_pay_status.setText("付款成功");
                holder.item_pay_status.setTextColor(Color.parseColor("#00ff00"));
                break;
            case 2:
                holder.item_pay_status.setText("已取消");
                holder.item_pay_status.setTextColor(Color.parseColor("#6666ff"));
                break;
        }
        return convertView;
    }

    class ViewHolder {
        private TextView item_title;
        private TextView item_pay_status;
        private Button item_pay_btn;
        private ImageView item_img;
        private TextView item_start_time;
        private TextView item_price;
    }


}
