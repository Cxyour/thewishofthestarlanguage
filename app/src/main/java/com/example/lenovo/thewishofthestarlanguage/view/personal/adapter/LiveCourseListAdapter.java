package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.CollectionBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class LiveCourseListAdapter extends BaseAdapter {

    private List<CollectionBean.DataBean.ListBean> listBeans;

    public LiveCourseListAdapter(List<CollectionBean.DataBean.ListBean> listBeans) {
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
            convertView = App.context.getLayoutInflater().inflate(R.layout.live_course_list_item, parent, false);
            holder.live_course_list_item_img = (ImageView) convertView.findViewById(R.id.live_course_list_item_img);
            holder.live_course_list_item_startData = (TextView) convertView.findViewById(R.id.live_course_list_item_startData);
            holder.live_course_list_item_nickname = (TextView) convertView.findViewById(R.id.live_course_list_item_nickname);
            holder.live_course_list_item_recy = (RecyclerView) convertView.findViewById(R.id.live_course_list_item_recy);
            holder.live_course_list_item_appointment = (TextView) convertView.findViewById(R.id.live_course_list_item_appointment);
            holder.live_courser_list_item_price = (TextView) convertView.findViewById(R.id.live_courser_list_item_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(App.context).load(listBeans.get(position).getCoverImg()).into(holder.live_course_list_item_img);
        holder.live_course_list_item_startData.setText("开课时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(listBeans.get(position).getStartDate())));
        holder.live_course_list_item_nickname.setText(listBeans.get(position).getNickname());
        holder.live_course_list_item_appointment.setText("已预约：" + listBeans.get(position).getSubscribe() + "/100");
        holder.live_courser_list_item_price.setText(listBeans.get(position).getPrice() + "");
        return convertView;
    }

    class ViewHolder {
        private ImageView live_course_list_item_img;
        private TextView live_course_list_item_startData;
        private TextView live_course_list_item_nickname;
        private RecyclerView live_course_list_item_recy;
        private TextView live_course_list_item_appointment;
        private TextView live_courser_list_item_price;
    }
}
