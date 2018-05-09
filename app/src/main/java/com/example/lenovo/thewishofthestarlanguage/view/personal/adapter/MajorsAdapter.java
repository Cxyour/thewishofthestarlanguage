package com.example.lenovo.thewishofthestarlanguage.view.personal.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LovesBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class MajorsAdapter extends BaseAdapter {

    private List<LovesBean.DataBean.MajorsBean> majorsBeans;

    public MajorsAdapter(List<LovesBean.DataBean.MajorsBean> majorsBeans) {
        this.majorsBeans = majorsBeans;
    }

    @Override
    public int getCount() {
        return majorsBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return majorsBeans.get(position);
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
            convertView = App.context.getLayoutInflater().inflate(R.layout.item_majors, parent, false);
            holder.majors_checked = convertView.findViewById(R.id.majors_checked);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.majors_checked.setText(majorsBeans.get(position).getName());
        return convertView;
    }


    class ViewHolder {
        private CheckBox majors_checked;
    }

}
