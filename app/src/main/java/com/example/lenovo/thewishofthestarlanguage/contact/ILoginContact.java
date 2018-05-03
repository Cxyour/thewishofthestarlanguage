package com.example.lenovo.thewishofthestarlanguage.contact;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface ILoginContact {

    interface ILoginView {
        void showLoginMessage(String string);
    }

    interface ILoginPresenter {
        void getLoginMessage(String userName, String passWord);
    }
}
