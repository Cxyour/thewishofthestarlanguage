package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface IFamousTeacherContract {

    interface IFamousTeacherView{
        void showFamousTecah(FamousTeacherBean famousTeacherBean);

    }
    interface IFamousTeacherPresenter{
        void  loadFrmousBean();
    }
}
