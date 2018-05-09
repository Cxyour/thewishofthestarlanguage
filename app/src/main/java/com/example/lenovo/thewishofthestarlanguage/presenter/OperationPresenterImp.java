package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.OperationContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.OperationService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public class OperationPresenterImp implements OperationContract.presenter {
    private  OperationService operationService;
    private OperationContract.view view;
    public OperationPresenterImp(OperationContract.view view) {
        this.view=view;
        operationService= RetrofitUtils.getInstance().getOperationService();
    }

    @Override
    public void loadOperationBean(int id) {
        operationService.loadOperationBean(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OperationBean>() {
                    @Override
                    public void accept(OperationBean operationBean) throws Exception {
                   view.showOperationBean(operationBean);
                    }
                });
    }
}
