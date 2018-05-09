package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IPersonalContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PersonalService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class PersonalPresenterImp implements IPersonalContract.IPersonalPresenter {

    private PersonalService personalService;
    private IPersonalContract.IPersonalView iPersonalView;

    public PersonalPresenterImp(IPersonalContract.IPersonalView iPersonalView) {
        personalService = RetrofitUtils.getInstance().getPersonalService();
        this.iPersonalView = iPersonalView;
    }

    @Override
    public void loadMyBean(int loginUserId) {
        personalService.getMyBean(loginUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        iPersonalView.showMyBean(myBean);
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
