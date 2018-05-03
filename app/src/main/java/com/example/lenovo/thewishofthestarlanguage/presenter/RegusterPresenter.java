package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.IRegisterContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.RegisterService;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public class RegusterPresenter implements IRegisterContract.IRegisterPresenter{
    IRegisterContract.IRegisterView view;
    RegisterService registerService;
    public RegusterPresenter(IRegisterContract.IRegisterView view) {
        this.view=view;
        registerService= RetrofitUtils.getInstance().getRegisterService();

    }

    @Override
    public void loadPhoneMsg(String phone) {
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("mobile",phone);

        registerService.loadPhoneMSG(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            view.showRegisterMsg(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RegusterPresenter", "e:" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void loadFirst(final String string, String phoneMsg) {
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("mobile",string);
        parmas.put("mobileValidCode",phoneMsg);
        registerService.loadFirst(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string1 = responseBody.string();
                            view.showFirst(string1);
                        } catch (IOException e) {


                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RegusterPresenter", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
