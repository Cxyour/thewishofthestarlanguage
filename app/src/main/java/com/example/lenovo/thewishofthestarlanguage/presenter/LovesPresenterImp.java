package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.ILovesContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LovesService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LovesBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class LovesPresenterImp implements ILovesContract.ILovesPresenter {

    private LovesService lovesService;
    private ILovesContract.ILovesView iLovesView;

    public LovesPresenterImp(ILovesContract.ILovesView iLovesView) {
        lovesService = RetrofitUtils.getInstance().getLovesService();
        this.iLovesView = iLovesView;
    }

    @Override
    public void loadLovesBean() {
        Observable<LovesBean> lovesBean = lovesService.getLovesBean();
        lovesBean.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LovesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LovesBean lovesBean) {
                        Log.e("-----------", lovesBean.getMessage());
                        iLovesView.showMajorsBean(lovesBean.getData().getMajors());
                        iLovesView.showCollegesBean(lovesBean.getData().getColleges());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void saveLoves(int userId, List<Integer> majorsIds, List<Integer> collegesIds) {
        Observable<SaveBean> responseBodyObservable = lovesService.saveLoves(userId, majorsIds, collegesIds);
        responseBodyObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SaveBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SaveBean saveBean) {
                        iLovesView.showSaveLovesMessage(saveBean.getMessage());
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
