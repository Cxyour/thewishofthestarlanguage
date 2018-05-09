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

public class CollegesAdapter extends BaseAdapter {

    private List<LovesBean.DataBean.CollegesBean> collegesBeans;

    public CollegesAdapter(List<LovesBean.DataBean.CollegesBean> collegesBeans) {
        this.collegesBeans = collegesBeans;
    }

    @Override
    public int getCount() {
        return collegesBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return collegesBeans.get(position);
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
            convertView = App.context.getLayoutInflater().inflate(R.layout.item_colleges, parent, false);
            holder.colleges_checked = convertView.findViewById(R.id.colleges_checked);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.colleges_checked.setText(collegesBeans.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        private CheckBox colleges_checked;
    }
}
