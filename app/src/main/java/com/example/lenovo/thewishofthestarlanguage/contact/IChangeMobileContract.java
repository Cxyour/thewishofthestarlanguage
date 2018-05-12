package com.example.lenovo.thewishofthestarlanguage.contact;

/**
 * Created by Lenovo on 2018/5/12.
 */

public interface IChangeMobileContract {

    interface IChangeMobileView {
        void showChangeMobileMessage(String string);
    }

    interface IChangeMobilePresenter {
        void changeMobile(int loginUserId, String mobile, String code);
    }

}
