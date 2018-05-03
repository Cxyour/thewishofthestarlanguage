package com.example.lenovo.thewishofthestarlanguage.contact;

import okhttp3.ResponseBody;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public interface IPerFectInforMationContact {
    interface IPerFectInlView{
        void showIperFect(ResponseBody responseBody);
    }

    interface IPerFectInPresenter{
        void loadIperFectMsg(String nicknamen,String sex,String photo,String mobile,String psw);
    }
}
