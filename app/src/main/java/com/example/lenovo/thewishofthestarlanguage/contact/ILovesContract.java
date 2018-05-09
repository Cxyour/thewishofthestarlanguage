package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.LovesBean;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2018/5/9.
 */

public interface ILovesContract {


    interface ILovesView {

        void showMajorsBean(List<LovesBean.DataBean.MajorsBean> majorsBeans);

        void showCollegesBean(List<LovesBean.DataBean.CollegesBean> collegesBeans);

        void showSaveLovesMessage(String string);
    }

    interface ILovesPresenter {

        void loadLovesBean();

        void saveLoves(int userId, List<Integer> majorsIds, List<Integer> collegesIds);
    }
}
