package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IChangeMobileContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.ChangeMobileService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/12.
 */

public class ChangeMobilePresenterImp implements IChangeMobileContract.IChangeMobilePresenter {

    private ChangeMobileService changeMobileService;
    private IChangeMobileContract.IChangeMobileView iChangeMobileView;

    public ChangeMobilePresenterImp(IChangeMobileContract.IChangeMobileView iChangeMobileView) {
        changeMobileService = RetrofitUtils.getInstance().getChangeMobileService();
        this.iChangeMobileView = iChangeMobileView;
    }

    @Override
    public void changeMobile(int loginUserId, String mobile, String code) {
        changeMobileService.changeMobile(loginUserId, mobile, code)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SaveBean>() {
                    @Override
                    public void accept(SaveBean saveBean) throws Exception {
                        iChangeMobileView.showChangeMobileMessage(saveBean.getMessage());
                    }
                });
    }
}
