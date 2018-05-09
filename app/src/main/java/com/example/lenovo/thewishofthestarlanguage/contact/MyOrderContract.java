package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MyOrderBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/8.
 */

public interface MyOrderContract {


    interface MyOrderView {
        void showMyOrder(List<MyOrderBean.DataBean.ListBean> list);
    }

    interface MyOrderPresenter {
        void getMyOrder(int userId, int status);
    }
}
