package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserSuccessBean;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface ILoginContract {

    interface ILoginView {
        /**
         * @param string
         */
        void showUserNameMessage(String string);

        /**
         * @param userSuccessBean
         */
        void showLoginMessage(UserSuccessBean userSuccessBean);
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


        void getLoginMessage(int userId);
    }
}
