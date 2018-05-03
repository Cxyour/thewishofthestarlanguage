package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface ILoginContract {

    interface ILoginView {
        /**
         *
         * @param string
         */
        void showUserNameMessage(String string);

        /**
         *
         * @param userBean
         */
        void showLoginMessage(UserBean userBean);
    }

    interface ILoginPresenter {
        /**
         * 用户名是否正确
         *
         * @param userName
         */
        boolean isUserName(String userName);
        /**
         * 去登陆
         *
         * @param userName
         * @param passWord
         */
        void goToLogin(String userName, String passWord);
    }
}
