package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.ITeacherFenSiContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.TeacherFensiService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TeacherFenSi;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public class TeacherFensiPresenterImp implements ITeacherFenSiContract.presenter {
    ITeacherFenSiContract.view view;
    TeacherFensiService service;
    public TeacherFensiPresenterImp(ITeacherFenSiContract.view view) {
        this.view=view;
        service= RetrofitUtils.getInstance().getTeacherFensiService();
    }

    @Override
    public void loadTeacherFensi(int id) {
        service.loadTeacherFenSi(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TeacherFenSi>() {
                    @Override
                    public void accept(TeacherFenSi teacherFenSi) throws Exception {
                        view.showTeacherFensi(teacherFenSi);
                    }
                });

    }
}
