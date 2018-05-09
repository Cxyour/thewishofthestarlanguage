package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IMostEaveContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MostEaveService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public class MostEavePresenterImp implements IMostEaveContract.presenter {
    private  IMostEaveContract.view view;
    private MostEaveService mostEaveModel;
    public MostEavePresenterImp(IMostEaveContract.view view) {
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
