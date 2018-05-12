package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.OperationContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.OperationService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.io.Serializable;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public class OperationPresenterImp implements OperationContract.presenter,Serializable {
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



    //点赞
    @Override
    public void loadGoodBean(Map<String,String> parmas) {
        operationService.loadGoodBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showGoodBean(goodOnClickBean);
                    }
                });

    }

    @Override
    public void loadReplyBean(Map<String, String> parmas) {
        operationService.loadReplyBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReplyBean>() {
                    @Override
                    public void accept(ReplyBean replyBean) throws Exception {
                        view.showReplyBean(replyBean);
                    }
                });

    }

    //取消赞
    @Override
    public void CancelthePraise(Map<String, String> parmas) {
        operationService.CancelthePraise(parmas)
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
