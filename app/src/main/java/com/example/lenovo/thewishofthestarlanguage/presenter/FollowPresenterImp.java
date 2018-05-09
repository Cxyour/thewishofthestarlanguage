package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IFollowContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FollowService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FollowBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/9.
 */

public class FollowPresenterImp implements IFollowContract.IFollowPresenter {

    private FollowService followService;
    private IFollowContract.IFollowView iFollowView;

    public FollowPresenterImp(IFollowContract.IFollowView iFollowView) {
        followService = RetrofitUtils.getInstance().getFollowService();
        this.iFollowView = iFollowView;
    }

    @Override
    public void loadFollowBean(int studentId) {
        Observable<FollowBean> followBean = followService.getFollowBean(studentId);
        followBean.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FollowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowBean followBean) {
                        iFollowView.showFollowBean(followBean.getData().getList());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
