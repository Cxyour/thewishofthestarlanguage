package com.example.lenovo.thewishofthestarlanguage.contact;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface IRegisterContract {

    interface IRegisterView{
        void showPhoneNumberMessage(String phoneNumberMessage);
        void showRegisterMsg(String string);
        void showFirst(String string);
    }

    interface IRegisterPresenter{
        /**
         * 用户名是否正确
         *
         * @param userName
         */
        boolean isUserName(String userName);
        void loadPhoneMsg(String phone);
        void loadFirst(String phone,String phoneMsg);
    }
}
