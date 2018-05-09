package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MyBean;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface IPersonalContract {

    interface IPersonalView {
        void showMyBean(MyBean myBean);
    }

    interface IPersonalPresenter {
        void loadMyBean(int loginUserId);
    }
}
