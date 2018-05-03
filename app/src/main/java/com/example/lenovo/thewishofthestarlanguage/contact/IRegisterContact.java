package com.example.lenovo.thewishofthestarlanguage.contact;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface IRegisterContact {

    interface IRegisterView{
        void showRegisterMsg(String string);
        void showFirst(String string);
    }

    interface IRegisterPresenter{
        void loadPhoneMsg(String phone);
        void loadFirst(String phone,String phoneMsg);
    }
}
