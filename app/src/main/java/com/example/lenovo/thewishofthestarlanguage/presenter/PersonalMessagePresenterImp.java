package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.contact.IPersonalMessageContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PersonalMessageService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.FollowBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyPersonalBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.PersonalMessageActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/10.
 */

public class PersonalMessagePresenterImp implements IPersonalMessageContract.IPersonalMessagePresenter {

    private PersonalMessageService myPersonalMessageService;
    private IPersonalMessageContract.IPersonalMessageView iMyPersonalView;

    public PersonalMessagePresenterImp(IPersonalMessageContract.IPersonalMessageView iMyPersonalView) {
        myPersonalMessageService = RetrofitUtils.getInstance().getMyPersonalMessageService();
        this.iMyPersonalView = iMyPersonalView;
    }

    @Override
    public void loadMyPersonalMessage(int loginUserId) {
        myPersonalMessageService.getMyPersonalMessage(loginUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyPersonalBean>() {
                    @Override
                    public void accept(MyPersonalBean myPersonalBean) throws Exception {
                        iMyPersonalView.showMyPersonalMessage(myPersonalBean);
                    }
                });
    }

    @Override
    public void followPersonal(int loginUserId) {
        Observable<FollowBean> followBean = myPersonalMessageService.personalFollow(loginUserId);
        followBean.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FollowBean>() {
                    @Override
                    public void accept(FollowBean followBean) throws Exception {
                        iMyPersonalView.showFollowStatus(followBean.getMessage());
                    }
                });
    }

    @Override
    public void personalAbolishConcern(int personalId, int loginUserId) {
        myPersonalMessageService.personalAbolishConcern(personalId, loginUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SaveBean>() {
                    @Override
                    public void accept(SaveBean saveBean) throws Exception {
                        iMyPersonalView.showAbolishConcern(saveBean.getMessage());
                    }
                });
    }
}
