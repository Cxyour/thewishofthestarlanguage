package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IPreviewContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PreviewService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public class PreviewPresenterImp implements IPreviewContract.presenter {
    IPreviewContract.view view;
    PreviewService model;

    public PreviewPresenterImp(IPreviewContract.view view) {
        this.view = view;
        model = RetrofitUtils.getInstance().getPreviewModel();
    }

    @Override
    public void loadPreview() {
        model.loadPreview().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PreviewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PreviewBean preview) {
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

    @Override
    public void screenTime(String startTime, String endTime) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("startDate", startTime);
        paramsMap.put("endDate", endTime);
        Observable<PreviewBean> previewBeanObservable = model.screenTime(paramsMap);
        previewBeanObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PreviewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PreviewBean previewBean) {
                        view.showPreview(previewBean);
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
