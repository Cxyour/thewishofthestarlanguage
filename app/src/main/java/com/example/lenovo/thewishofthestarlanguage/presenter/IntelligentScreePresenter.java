package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IntelligentScreeContarct;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MostEaveModel;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public class IntelligentScreePresenter implements IntelligentScreeContarct.presenter{
    private  IntelligentScreeContarct.view view;
    private MostEaveModel mostEaveModel;
    public IntelligentScreePresenter(IntelligentScreeContarct.view view) {
        this.view=view;
        mostEaveModel= RetrofitUtils.getInstance().getMostEaveModel();
    }

    @Override
    public void loadMostEavesdeopp() {
        HashMap<String, String> parmas= new HashMap<>();
        parmas.put("sortord","1");
        mostEaveModel.loadMostBean(parmas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MostEavesdeoppBean>() {
                    @Override
                    public void accept(MostEavesdeoppBean mostEavesdeoppBean) throws Exception {
                        view.showMostEavesdeopp(mostEavesdeoppBean);
                    }
                });
    }
}
