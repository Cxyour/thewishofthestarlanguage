package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IFamousTeacherContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FamousTeacherService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;



/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public class FamousTeacherPresenterImp implements IFamousTeacherContract.IFamousTeacherPresenter{
    IFamousTeacherContract.IFamousTeacherView view;
    FamousTeacherService famousTeacherService;
    public FamousTeacherPresenterImp(IFamousTeacherContract.IFamousTeacherView view) {
        this.view=view;
        famousTeacherService= RetrofitUtils.getInstance().getFamousTeacherService();
    }

    @Override
    public void loadFrmousBean() {
        famousTeacherService.loadFamousBean()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FamousTeacherBean>() {
                    @Override
                    public void accept(FamousTeacherBean famousTeacherBean) throws Exception {
                        view.showFamousTecah(famousTeacherBean);
                    }
                });
    }
    //点赞
    @Override
    public void loadGoodBean(Map<String,String> parmas) {
        famousTeacherService.loadGoodBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showGoodBean(goodOnClickBean);
                    }
                });

    }

    //取消赞
    @Override
    public void CancelthePraise(Map<String, String> parmas) {
        famousTeacherService.CancelthePraise(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showCancelthePraise(goodOnClickBean);
                    }
                });
    }

    //收藏
    @Override
    public void Collection(Map<String, String> parmas) {
        famousTeacherService.Collection(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showCancelthePraise(goodOnClickBean);
                    }
                });
    }

    //取消收藏
    @Override
    public void CancelTheCollection(Map<String, String> parmas) {
        famousTeacherService.CancelTheCollection(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodOnClickBean>() {
                    @Override
                    public void accept(GoodOnClickBean goodOnClickBean) throws Exception {
                        view.showCancelthePraise(goodOnClickBean);
                    }
                });
    }
}
