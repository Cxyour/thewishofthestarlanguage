package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IMasterContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MasterService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class MasterPresenterImp implements IMasterContract.presenter {
    MasterService service;
    IMasterContract.view view;
    public MasterPresenterImp(IMasterContract.view view) {
        this.view=view;
        service= RetrofitUtils.getInstance().getMasterService();
    }

    @Override
    public void loadMasterBean(int id) {
   service.loadMasterBean(id)
           .subscribeOn(Schedulers.newThread())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(new Consumer<MasterBean>() {
               @Override
               public void accept(MasterBean masterBean) throws Exception {
                   view.showMasterBean(masterBean);
               }
           });
    }
}
