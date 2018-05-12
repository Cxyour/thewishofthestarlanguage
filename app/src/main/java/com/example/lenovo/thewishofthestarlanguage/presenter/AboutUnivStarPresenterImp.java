package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IAboutUnivStarContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.AboutUnivStarService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.AboutUnivStarBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class AboutUnivStarPresenterImp implements IAboutUnivStarContract.IAboutUnivStarPresenter {

    private AboutUnivStarService aboutUnivStarService;
    private IAboutUnivStarContract.IAboutUnivStarView iAboutUnivStarView;

    public AboutUnivStarPresenterImp(IAboutUnivStarContract.IAboutUnivStarView iAboutUnivStarView) {
        aboutUnivStarService = RetrofitUtils.getInstance().getAboutUnivStarService();
        this.iAboutUnivStarView = iAboutUnivStarView;
    }

    @Override
    public void loadAboutUnivStarMessage() {
        aboutUnivStarService.loadAboutUnivStarMessage()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AboutUnivStarBean>() {
                    @Override
                    public void accept(AboutUnivStarBean aboutUnivStarBean) throws Exception {
                        iAboutUnivStarView.showAboutUnivStarMessage(aboutUnivStarBean);
                    }
                });
    }
}
