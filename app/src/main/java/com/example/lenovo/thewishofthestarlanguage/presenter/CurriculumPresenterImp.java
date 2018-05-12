package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.ITaskContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.CurriculumService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public class CurriculumPresenterImp implements ITaskContract.presenter {
    ITaskContract.view view;
    CurriculumService service;
    public CurriculumPresenterImp(ITaskContract.view view) {
        this.view=view;
        service= RetrofitUtils.getInstance().getCurriculumService();
    }

    @Override
    public void loadTaskBean(int id) {
        service.loadTaskBean(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TaskBean>() {
                    @Override
                    public void accept(TaskBean taskBean) throws Exception {
                        view.showTaskBean(taskBean);
                    }
                });
    }
}
