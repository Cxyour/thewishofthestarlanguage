package com.example.lenovo.thewishofthestarlanguage.contact;

import java.util.Map;

/**
 * Created by Lenovo on 2018/5/13.
 */

public interface IMessageChangeContract {

    interface IMessageChangeView {
        void showMessageChangeMessage(String string);
    }

    interface IMessageChangePresenter {
        void messageChange(int user, Map<String, String> paramsMap);
    }

}
