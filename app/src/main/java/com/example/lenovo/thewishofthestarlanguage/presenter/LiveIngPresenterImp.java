package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.LiveIngContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LiveIngService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LiveDetailsBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LivePurchaseBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class LiveIngPresenterImp implements LiveIngContract.presenter {
    LiveIngService service;
    LiveIngContract.view view;
    public LiveIngPresenterImp(LiveIngContract.view view) {
        this.view=view;
        service= RetrofitUtils.getInstance().getLiveIngService();
    }

    @Override
    public void loadLiveBean(String string) {
        service.loadLiveBean(string)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LiveDetailsBean>() {
                    @Override
                    public void accept(LiveDetailsBean liveDetailsBean) throws Exception {
                        view.showLiveBean(liveDetailsBean);
                    }
                });
    }

    @Override
    public void loadLivePurchaseBean(int id) {
        service.loadLivePurchaseBean(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LivePurchaseBean>() {
                    @Override
                    public void accept(LivePurchaseBean livePurchaseBean) throws Exception {
                        view.showLivePurchaseBean(livePurchaseBean);
                    }
                });
    }

    //收藏
    @Override
    public void Collection(Map<String, String> parmas) {
        service.Collection(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showCancelthePraise(goodOnClickBean);
                    }
                });
    }

    //取消收藏
    @Override
    public void CancelTheCollection(Map<String, String> parmas) {
        service.CancelTheCollection(parmas)
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
