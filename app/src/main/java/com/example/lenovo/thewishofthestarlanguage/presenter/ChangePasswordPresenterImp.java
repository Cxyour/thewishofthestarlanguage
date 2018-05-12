package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IChangePasswordContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.ChangePasswordService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class ChangePasswordPresenterImp implements IChangePasswordContract.IChangePasswordPresenter {

    private ChangePasswordService changePasswordService;
    private IChangePasswordContract.IChangePasswordView iChangePasswordView;

    public ChangePasswordPresenterImp(IChangePasswordContract.IChangePasswordView iChangePasswordView) {
        changePasswordService = RetrofitUtils.getInstance().getChangePasswordService();
        this.iChangePasswordView = iChangePasswordView;
    }

    @Override
    public void loadCodeMessage(String mobile, String authCode) {
        changePasswordService.isCodeSuccess(mobile, authCode)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SaveBean>() {
                    @Override
                    public void accept(SaveBean saveBean) throws Exception {
                        iChangePasswordView.showCodeMessage(saveBean.getMessage());
                    }
                });
    }
}
