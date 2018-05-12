package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IResetPassWordContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.ResetPassWordService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;
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
 * Created by Lenovo on 2018/5/4.
 */

public class ResetPassWordPresenterImp implements IResetPassWordContract.IResetPassWordPresenter {

    private ResetPassWordService resetPassWordService;
    private IResetPassWordContract.IResetPassWordView iResetPassWordView;

    public ResetPassWordPresenterImp(IResetPassWordContract.IResetPassWordView iResetPassWordView) {
        resetPassWordService = RetrofitUtils.getInstance().getResetService();
        this.iResetPassWordView = iResetPassWordView;
    }

    @Override
    public boolean isPassWordSame(String newPassWord, String newPassWordAgain) {
        if (newPassWord.equals(newPassWordAgain)) {
            return true;
        }
        iResetPassWordView.showToastMessage("密码不一致");
        return false;
    }

    @Override
    public void resetPassWord(String phoneNumber, String newPassWord, String newPassWordAgain) {
        if (!isPassWordSame(newPassWord, newPassWordAgain))
            return;
        Observable<UserBean> responseBodyObservable = resetPassWordService.resetPassWord(phoneNumber,newPassWord);
        responseBodyObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        iResetPassWordView.showResetMessage(userBean);
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
