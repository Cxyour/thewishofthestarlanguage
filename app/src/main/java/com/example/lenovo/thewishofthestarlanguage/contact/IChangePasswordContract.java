package com.example.lenovo.thewishofthestarlanguage.contact;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface IChangePasswordContract {

    interface IChangePasswordView {
        void showCodeMessage(String string);
    }

    interface IChangePasswordPresenter {

        void loadCodeMessage(String mobile, String authCode);
    }

}
