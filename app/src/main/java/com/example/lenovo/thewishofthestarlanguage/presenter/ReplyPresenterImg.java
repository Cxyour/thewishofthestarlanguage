package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IReplyContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.ReplyService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyTwoBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/11.
 */

public class ReplyPresenterImg implements IReplyContract.presenter {
    IReplyContract.view view;
    ReplyService service;
    public ReplyPresenterImg(IReplyContract.view view) {
        this.view=view;
        service= RetrofitUtils.getInstance().getReplyService();
    }

    @Override
    public void loadReplyTwoBean(Map<String, String> map) {
        service.loadReplyTwoBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReplyTwoBean>() {
                    @Override
                    public void accept(ReplyTwoBean replyTwoBean) throws Exception {
                        view.showReplyTwoBean(replyTwoBean);
                    }
                });
    }

    @Override
    public void loadReplyBean(Map<String, String> parmas) {
        service.loadReplyBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReplyBean>() {
                    @Override
                    public void accept(ReplyBean replyBean) throws Exception {

                    }
                });
    }
}
