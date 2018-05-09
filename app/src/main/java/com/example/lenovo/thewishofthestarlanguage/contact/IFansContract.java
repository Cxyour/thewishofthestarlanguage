package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FansBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FollowBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/9.
 */

public interface IFansContract {

    interface IFansView {
        void showFansBean(List<FansBean.DataBean.ListBean> listBeans);
    }

    interface IFansPresenter {
        void loadFansBean(int studentId);
    }

}
