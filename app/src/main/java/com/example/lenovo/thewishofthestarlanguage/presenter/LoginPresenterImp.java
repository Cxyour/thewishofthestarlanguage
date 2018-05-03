package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.ILoginContact;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LoginService;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Lenovo on 2018/5/3.
 */

public class LoginPresenterImp implements ILoginContact.ILoginPresenter {

    private LoginService loginService;
    private ILoginContact.ILoginView iLoginView;

    public LoginPresenterImp(ILoginContact.ILoginView iLoginView) {
        loginService = RetrofitUtils.getInstance().getLoginService();
        this.iLoginView = iLoginView;
    }

    @Override
    public void getLoginMessage(String userName, String passWord) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("mobile", userName);
        paramsMap.put("password", passWord);
        Observable<ResponseBody> loginMessage = loginService.getLoginMessage(paramsMap);
        loginMessage.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("------------------",d.toString());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            iLoginView.showLoginMessage(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("------------------",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("------------------","----------------");
                    }
                });
    }
}
