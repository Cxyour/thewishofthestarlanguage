package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.MostEaveContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MostEaveService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public class MostEavePresenterImp implements MostEaveContract.presenter {
    private  MostEaveContract.view view;
    private MostEaveService mostEaveModel;
    public MostEavePresenterImp(MostEaveContract.view view) {
        this.view=view;
        mostEaveModel= RetrofitUtils.getInstance().getMostEaveModel();
    }

    @Override
    public void loadMostEavesdeopp(Integer string) {
        HashMap<String, Integer> parmas= new HashMap<>();
        parmas.put("sortord",string);
        mostEaveModel.loadMostBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MostEavesdeoppBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MostEavesdeoppBean mostEavesdeoppBean) {
                    view.showMostEavesdeopp(mostEavesdeoppBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //点赞
    @Override
    public void loadGoodBean(Map<String,String> parmas) {
        mostEaveModel.loadGoodBean(parmas)
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
        mostEaveModel.CancelthePraise(parmas)
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
        mostEaveModel.Collection(parmas)
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
        mostEaveModel.CancelTheCollection(parmas)
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
