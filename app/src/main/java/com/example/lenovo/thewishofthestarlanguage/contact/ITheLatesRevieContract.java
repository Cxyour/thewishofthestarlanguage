package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public interface ITheLatesRevieContract {
    interface  view{
        void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean);
    }
    interface  presenter{
        void loadMostEavesdeopp();
    }
}
