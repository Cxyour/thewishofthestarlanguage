package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IPreviewDetailsContact;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PrevieDetailsService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewActivityBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class PreviewActivityPresenterImp implements IPreviewDetailsContact.presenter{
    IPreviewDetailsContact.view view;
    PrevieDetailsService previeDetailsService;
    public PreviewActivityPresenterImp(IPreviewDetailsContact.view view) {
        this.view=view;
        previeDetailsService= RetrofitUtils.getInstance().getPrevieDetailsService();
    }

    @Override
    public void loadPreviewActivityBean(int id) {
        previeDetailsService.loadPreviewActivityBean(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PreviewActivityBean>() {
                    @Override
                    public void accept(PreviewActivityBean previewActivityBean) throws Exception {
                        view.showPreviewActivityBean(previewActivityBean);
                    }
                });
    }
}
