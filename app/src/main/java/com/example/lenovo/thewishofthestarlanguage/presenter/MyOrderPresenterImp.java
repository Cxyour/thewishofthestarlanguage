package com.example.lenovo.thewishofthestarlanguage.presenter;

import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.contact.IMyOrderContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MyOrderService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MyOrderBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/8.
 */

public class MyOrderPresenterImp implements IMyOrderContract.MyOrderPresenter {

    private MyOrderService myOrderService;
    private IMyOrderContract.MyOrderView myOrderView;

    public MyOrderPresenterImp(IMyOrderContract.MyOrderView myOrderView) {
        myOrderService = RetrofitUtils.getInstance().getMyOrderService();
        this.myOrderView = myOrderView;
    }

    @Override
    public void getMyOrder(int userId, int status) {
        Observable<MyOrderBean> myOrder = myOrderService.getMyOrder(userId, status);
        myOrder.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyOrderBean myOrderBean) {
                        Log.e("-------", String.valueOf(myOrderBean.getData().getList().size()));
                        List<MyOrderBean.DataBean.ListBean> list = myOrderBean.getData().getList();
                        myOrderView.showMyOrder(list);
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
