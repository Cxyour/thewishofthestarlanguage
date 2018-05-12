package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.AboutUnivStarBean;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface IAboutUnivStarContract {

    interface IAboutUnivStarView {
        void showAboutUnivStarMessage(AboutUnivStarBean aboutUnivStarBean);
    }

    interface IAboutUnivStarPresenter {
        void loadAboutUnivStarMessage();
    }

}
