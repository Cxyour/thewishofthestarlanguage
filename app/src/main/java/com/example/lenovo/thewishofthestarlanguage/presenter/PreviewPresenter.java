package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.PreviewContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PreviewModel;
import com.example.lenovo.thewishofthestarlanguage.model.entity.Preview;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public class PreviewPresenter implements PreviewContract.presenter {
    PreviewContract.view view;
    PreviewModel model;
    public PreviewPresenter( PreviewContract.view view) {
        this.view=view;
        model= RetrofitUtils.getInstance().getPreviewModel();
    }

    @Override
    public void loadPreview() {
        model.loadPreview().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Preview>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Preview preview) {
                        view.showPreview(preview);
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
