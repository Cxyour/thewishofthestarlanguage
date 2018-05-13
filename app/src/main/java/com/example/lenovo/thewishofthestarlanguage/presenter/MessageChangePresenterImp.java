package com.example.lenovo.thewishofthestarlanguage.presenter;


import com.example.lenovo.thewishofthestarlanguage.contact.IMessageChangeContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MessageChangeService;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Lenovo on 2018/5/13.
 */

public class MessageChangePresenterImp implements IMessageChangeContract.IMessageChangePresenter {

    private MessageChangeService messageChangeService;
    private IMessageChangeContract.IMessageChangeView iMessageChangeView;

    public MessageChangePresenterImp(IMessageChangeContract.IMessageChangeView iMessageChangeView) {
        messageChangeService = RetrofitUtils.getInstance().getMessageChangeService();
        this.iMessageChangeView = iMessageChangeView;
    }

    @Override
    public void messageChange(int user, Map<String, String> paramsMap) {
        messageChangeService.messageChange(user, paramsMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        iMessageChangeView.showMessageChangeMessage(responseBody.string());
                    }
                });
    }
}
