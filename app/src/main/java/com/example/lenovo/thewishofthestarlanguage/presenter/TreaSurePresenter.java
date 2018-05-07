package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.TreasureContact;
import com.example.lenovo.thewishofthestarlanguage.model.biz.TreaSureService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSure;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTu;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class TreaSurePresenter implements TreasureContact.presenter {
    TreasureContact.view view;
    TreaSureService treaSureService;
    public TreaSurePresenter( TreasureContact.view view) {
        this.view=view;
        treaSureService= RetrofitUtils.getInstance().getTreaSureService();
    }

    @Override
    public void loadTreSure(int index) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sortord",index);
        treaSureService.loadTreaSure(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreaSure>() {
                    @Override
                    public void accept(TreaSure treaSure) throws Exception {
                        view.showTreSure(treaSure);
                    }
                });
    }

    @Override
    public void loadLunbotu() {
        treaSureService.loadTreaSureLunBoTu()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreaSureLunBoTu>() {
                    @Override
                    public void accept(TreaSureLunBoTu treaSureLunBoTu) throws Exception {
                    view.showLunbotu(treaSureLunBoTu);
                    }
                });
    }
}
