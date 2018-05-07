package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.IFindPassWordContract;
import com.example.lenovo.thewishofthestarlanguage.contact.IRegisterContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FindPassWordService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.RegisterService;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.Date;
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

public class FindPassWordPresenterImp implements IFindPassWordContract.IFindPassWordPresenter {
    IFindPassWordContract.IFindPassWordView iFindPassWordView;
    FindPassWordService findPassWordService;

    public FindPassWordPresenterImp(IFindPassWordContract.IFindPassWordView iFindPassWordView) {
        this.iFindPassWordView = iFindPassWordView;
        findPassWordService = RetrofitUtils.getInstance().getFindPassWordService();

    }

    @Override
    public boolean isUserName(String phoneNumber) {
        iFindPassWordView.showPhoneNumberMessage(null);
        if (TextUtils.isEmpty(phoneNumber)) {
            iFindPassWordView.showPhoneNumberMessage("邮箱/手机号不能为空");
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
            iFindPassWordView.showPhoneNumberMessage(null);
            return true;
        } else {
            iFindPassWordView.showPhoneNumberMessage("邮箱/手机格式不正确");
            return false;
        }
    }

    @Override
    public void loadPhoneMsg(String phoneNumber) {
        if (!isUserName(phoneNumber))
            return;
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("mobile", phoneNumber);

        findPassWordService.loadPhoneMSG(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RegisterPresenterImp", "e:" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void goToResetPassWord(String phoneNumber, String phoneCode) {
        if (!isUserName(phoneNumber))
            return;
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("mobile", phoneNumber);
        parmas.put("mobileValidCode", phoneCode);
        findPassWordService.goToResetPassWord(parmas)
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


                        } catch (IOException e) {


                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RegisterPresenterImp", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
