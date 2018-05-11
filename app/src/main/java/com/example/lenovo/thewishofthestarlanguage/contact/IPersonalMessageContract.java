package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MyPersonalBean;

/**
 * Created by Lenovo on 2018/5/10.
 */

public interface IPersonalMessageContract {

    interface IPersonalMessageView {
        void showMyPersonalMessage(MyPersonalBean myPersonalBean);

        void showFollowStatus(String string);

        void showAbolishConcern(String string);
    }

    interface IPersonalMessagePresenter {

        void loadMyPersonalMessage(int loginUserId);

        void followPersonal(int loginUserId);

        void personalAbolishConcern(int personalId, int loginUserId);
    }
}
