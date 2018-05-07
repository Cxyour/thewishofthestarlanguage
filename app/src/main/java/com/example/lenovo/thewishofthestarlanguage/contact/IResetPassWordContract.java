package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;

/**
 * Created by Lenovo on 2018/5/4.
 */

public interface IResetPassWordContract {

    interface IResetPassWordView {
        void showToastMessage(String string);

        void showResetMessage(UserBean userBean);
    }

    interface IResetPassWordPresenter {
        boolean isPassWordSame(String newPassWord, String newPassWordAgain);

        void resetPassWord(String phoneNumber, String newPassWord, String newPassWordAgain);
    }
}
