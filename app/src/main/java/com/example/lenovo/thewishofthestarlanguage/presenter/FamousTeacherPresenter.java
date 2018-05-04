package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.IFamousTeacherContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FamousTeacherService;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public class FamousTeacherPresenter implements IFamousTeacherContract.IFamousTeacherPresenter{
    IFamousTeacherContract.IFamousTeacherView view;
    FamousTeacherService famousTeacherService;
    public FamousTeacherPresenter(IFamousTeacherContract.IFamousTeacherView view) {
        this.view=view;
        famousTeacherService= RetrofitUtils.getInstance().getFamousTeacherService();
    }

    @Override
    public void loadFrmousBean() {
        HashMap<String, String> map = new HashMap<>();
        SharedPreferences user = App.context.getSharedPreferences("user", 0);
        String headerApptoken = user.getString("headerApptoken", null);
        Log.e("FamousTeacherPresenter", headerApptoken);
        map.put("apptoken",headerApptoken);
        famousTeacherService.loadFamousBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FamousTeacherBean>() {
                    @Override
                    public void accept(FamousTeacherBean famousTeacherBean) throws Exception {
                        view.showFamousTecah(famousTeacherBean);
                    }
                });
    }
}
