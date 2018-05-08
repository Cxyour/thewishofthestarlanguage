package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IDetailsContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.TreasureDetailsServiece;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreasurteActiviyBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class DetailsPresenterImp implements IDetailsContract.presenter{
    IDetailsContract.view view;
    TreasureDetailsServiece previewDetailsServiece;
    public DetailsPresenterImp(IDetailsContract.view view) {
        this.view=view;
        previewDetailsServiece= RetrofitUtils.getInstance().getPreviewDetailsServiece();
    }

    @Override
    public void loadPreviewActiviyBean(int id) {
        previewDetailsServiece.loadPreviewActiviyBean(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreasurteActiviyBean>() {
                    @Override
                    public void accept(TreasurteActiviyBean previewActiviyBean) throws Exception {
                        view.showPreviewActiviyBean(previewActiviyBean);
                    }
                });

    }
}
