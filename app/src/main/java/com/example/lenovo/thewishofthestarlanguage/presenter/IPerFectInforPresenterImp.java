package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IPerFectInforMationContact;
import com.example.lenovo.thewishofthestarlanguage.contact.IPerFectInforMationContact.IPerFectInPresenter;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PerFectInforService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public class IPerFectInforPresenterImp implements IPerFectInPresenter {
    IPerFectInforMationContact.IPerFectInlView view;
    PerFectInforService perFectInforService;
    public IPerFectInforPresenterImp(IPerFectInforMationContact.IPerFectInlView view) {
        this.view=view;
        perFectInforService= RetrofitUtils.getInstance().getPerFectInforService();

    }

    @Override
    public void loadIperFectMsg(String nicknamen, String sex, String photo, String mobile, String psw) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nickname",nicknamen);
        map.put("sex",sex);
        map.put("photo",photo);
        map.put("mobile",mobile);
        map.put("psw",psw);
      perFectInforService.loadIperFectMsg(map)
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeOn(Schedulers.newThread())
              .subscribe(new Consumer<PerFectInforBean>() {
                  @Override
                  public void accept(PerFectInforBean perFectInforBean) throws Exception {
                      view.showIperFect(perFectInforBean);
                  }
              });
    }
}
