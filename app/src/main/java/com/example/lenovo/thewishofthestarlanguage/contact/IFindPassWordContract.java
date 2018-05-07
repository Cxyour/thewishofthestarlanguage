package com.example.lenovo.thewishofthestarlanguage.contact;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface IFindPassWordContract {

    interface IFindPassWordView {
        void showPhoneNumberMessage(String phoneNumberMessage);
    }

    interface IFindPassWordPresenter {
        /**
         * 用户名是否正确
         *
         * @param userName
         */
        boolean isUserName(String userName);

        void loadPhoneMsg(String phone);

        void goToResetPassWord(String newPassWord, String newPassWordAgain);
    }
}
