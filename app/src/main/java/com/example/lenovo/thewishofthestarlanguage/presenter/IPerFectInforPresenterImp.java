package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.contact.IPerFectInforMationContact;
import com.example.lenovo.thewishofthestarlanguage.contact.IPerFectInforMationContact.IPerFectInPresenter;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PerFectInforService;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UpLoadBitmapBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public class IPerFectInforPresenterImp implements IPerFectInPresenter {
    IPerFectInforMationContact.IPerFectInlView view;
    PerFectInforService perFectInforService;

    public IPerFectInforPresenterImp(IPerFectInforMationContact.IPerFectInlView view) {
        this.view = view;
        perFectInforService = RetrofitUtils.getInstance().getPerFectInforService();

    }

    @Override
    public void loadIperFectMsg(String nicknamen, Integer sex, String photo, String mobile, String psw) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nickname", nicknamen);
        map.put("photo", photo);
        map.put("mobile", mobile);
        map.put("psw", psw);
        perFectInforService.loadIperFectMsg(map, sex)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<PerFectInforBean>() {
                    @Override
                    public void accept(PerFectInforBean perFectInforBean) throws Exception {
                        view.showIperFect(perFectInforBean);
                    }
                });
    }

    @Override
    public void loadBitmapUrl(File file) {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart("file", file.getName(), imageBody);
        List<MultipartBody.Part> parts = builder.build().parts();
        perFectInforService.uploadImg(parts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpLoadBitmapBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpLoadBitmapBean upLoadBitmapBean) {
                        Log.e("--------------", upLoadBitmapBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "上传头像: " + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
