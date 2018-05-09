package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;

import java.io.File;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public interface IPerFectInforMationContact {
    interface IPerFectInlView {
        void showIperFect(PerFectInforBean responseBody);

        void showBitmapUrl(String url);
    }

    interface IPerFectInPresenter {
        void loadIperFectMsg(String nicknamen, Integer sex, String photo, String mobile, String psw);

        void loadBitmapUrl(File file);
    }
}
