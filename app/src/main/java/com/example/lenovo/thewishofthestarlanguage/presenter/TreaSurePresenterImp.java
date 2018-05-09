package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.ITreasureContact;
import com.example.lenovo.thewishofthestarlanguage.model.biz.TreaSureService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTuBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class TreaSurePresenterImp implements ITreasureContact.presenter {
    ITreasureContact.view view;
    TreaSureService treaSureService;

    public TreaSurePresenterImp(ITreasureContact.view view) {
        this.view = view;
        treaSureService = RetrofitUtils.getInstance().getTreaSureService();
    }

    @Override
    public void loadTreSure(int index) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sortord", index);
        treaSureService.loadTreaSure(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreaSureBean>() {
                    @Override
                    public void accept(TreaSureBean treaSure) throws Exception {
                        view.showTreSure(treaSure);
                    }
                });
    }

    @Override
    public void loadLunbotu() {
        treaSureService.loadTreaSureLunBoTu()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreaSureLunBoTuBean>() {
                    @Override
                    public void accept(TreaSureLunBoTuBean treaSureLunBoTu) throws Exception {
                        view.showLunbotu(treaSureLunBoTu);
                    }
                });
    }


    //点赞
    @Override
    public void loadGoodBean(Map<String,String> parmas) {
        treaSureService.loadGoodBean(parmas)
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
        treaSureService.CancelthePraise(parmas)
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
        treaSureService.Collection(parmas)
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
        treaSureService.CancelTheCollection(parmas)
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
