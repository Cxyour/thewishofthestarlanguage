package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.IRegisterContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.RegisterService;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public class RegusterPresenter implements IRegisterContract.IRegisterPresenter {
    IRegisterContract.IRegisterView iRegisterView;
    RegisterService registerService;

    public RegusterPresenter(IRegisterContract.IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        registerService = RetrofitUtils.getInstance().getRegisterService();

    }

    @Override
    public boolean isUserName(String phoneNumber) {
        iRegisterView.showPhoneNumberMessage(null);
        if (TextUtils.isEmpty(phoneNumber)) {
            iRegisterView.showPhoneNumberMessage("邮箱/手机号不能为空");
            return false;
        }
        String tEmail = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        if (phoneNumber.indexOf("@") == -1) {
            tEmail = "^1[3578]\\d{9}$";
        }
        Pattern pattern = Pattern
                .compile(tEmail);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            iRegisterView.showPhoneNumberMessage(null);
            return true;
        } else {
            iRegisterView.showPhoneNumberMessage("邮箱/手机格式不正确");
            return false;
        }
    }

    @Override
    public void loadPhoneMsg(String phoneNumber) {
        if (!isUserName(phoneNumber))
            return;
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("mobile", phoneNumber);

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
                            iRegisterView.showRegisterMsg(responseBody.string());
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
    public void loadFirst(final String phoneNumber, String phoneCode) {
        if (isUserName(phoneNumber)) ;
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("mobile", phoneNumber);
        parmas.put("mobileValidCode", phoneCode);
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
                            iRegisterView.showFirst(string1);
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
