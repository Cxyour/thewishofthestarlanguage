package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public interface OperationContract {

    interface  view{
        void showOperationBean(OperationBean operationBean);
    }
    interface  presenter{
        void loadOperationBean(int id);

    }
}
