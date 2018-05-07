package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public interface IPerFectInforMationContact {
    interface IPerFectInlView{
        void showIperFect(PerFectInforBean responseBody);
    }

    interface IPerFectInPresenter{
        void loadIperFectMsg(String nicknamen,String sex,String photo,String mobile,String psw);
    }
}
