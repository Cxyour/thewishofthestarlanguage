package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterBean;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public interface IMasterContract  {
    interface  view{
        void showMasterBean(MasterBean masterBean);
    }
    interface  presenter{
        void loadMasterBean(int id);
    }
}
