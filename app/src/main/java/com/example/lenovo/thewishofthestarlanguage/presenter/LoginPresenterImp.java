package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.text.TextUtils;

import com.example.lenovo.thewishofthestarlanguage.contact.ILoginContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LoginService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/3.
 */

public class LoginPresenterImp implements ILoginContract.ILoginPresenter {

    private LoginService loginService;
    private ILoginContract.ILoginView iLoginView;

    public LoginPresenterImp(ILoginContract.ILoginView iLoginView) {
        loginService = RetrofitUtils.getInstance().getLoginService();
        this.iLoginView = iLoginView;
    }

    @Override
    public boolean isUserName(String userName) {
        iLoginView.showUserNameMessage(null);
        if (TextUtils.isEmpty(userName)) {
            iLoginView.showUserNameMessage("邮箱/手机号不能为空");
            return false;
        }
        String tEmail = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        if (userName.indexOf("@") == -1) {
            tEmail = "^1[3578]\\d{9}$";
        }
        Pattern pattern = Pattern
                .compile(tEmail);
        Matcher matcher = pattern.matcher(userName);
        if (matcher.matches()) {
            iLoginView.showUserNameMessage(null);
            return true;
        } else {
            iLoginView.showUserNameMessage("邮箱/手机格式不正确");
            return false;
        }
    }

    @Override
    public void goToLogin(String userName, String passWord) {
        if (!isUserName(userName))
            return;
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("mobile", userName);
        paramsMap.put("password", passWord);
        Observable<UserBean> loginMessage = loginService.getLoginMessage(paramsMap);
        loginMessage.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        iLoginView.showLoginMessage(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
