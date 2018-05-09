package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.MasterHomeContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MasterHomeService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterHomeBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class MoasterHomePresenterImp implements MasterHomeContract.presenter {
    MasterHomeContract.view view;
    MasterHomeService service;
    public MoasterHomePresenterImp(MasterHomeContract.view view) {
        this.view=view;
        service= RetrofitUtils.getInstance().getMasterHomeService();
    }

    @Override
    public void loadMasterHomeBean(int teacherId) {
        service.loadMasterHomeBean(teacherId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MasterHomeBean>() {
                    @Override
                    public void accept(MasterHomeBean masterHomeBean) throws Exception {
                        view.showMasterHomeBean(masterHomeBean);
                    }
                });
    }

    //点赞
    @Override
    public void loadGoodBean(Map<String,String> parmas) {
        service.loadGoodBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showGoodBean(goodOnClickBean);
                    }
                });

    }

    //取消赞
    @Override
    public void CancelthePraise(Map<String, String> parmas) {
        service.CancelthePraise(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showCancelthePraise(goodOnClickBean);
                    }
                });
    }
}
