package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IVoucherCenterContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.VoucherCenterService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.DouDou;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OrderMsgBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/10.
 */

public class VoucherCenterPresenterImp implements IVoucherCenterContract.IVoucherCenterPresenter {

    private VoucherCenterService voucherCenterService;
    private IVoucherCenterContract.IVoucherCenterView iVoucherCenterView;

    public VoucherCenterPresenterImp(IVoucherCenterContract.IVoucherCenterView iVoucherCenterView) {
        voucherCenterService = RetrofitUtils.getInstance().getVoucherCenterService();
        this.iVoucherCenterView = iVoucherCenterView;
    }

    @Override
    public void loadData(int loginUserId) {
        voucherCenterService.loadData(loginUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VoucherBean>() {
                    @Override
                    public void accept(VoucherBean voucherBean) throws Exception {
                        iVoucherCenterView.showData(voucherBean);
                    }
                });
    }

    @Override
    public void loadDouDou(Map<String, String> pramas) {
        voucherCenterService.loadDouDou(pramas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DouDou>() {
                    @Override
                    public void accept(DouDou douDou) throws Exception {
                        iVoucherCenterView.showDouDou(douDou);
                    }
                });
    }

    @Override
    public void loadOrderMsgBean(String orderNo) {
        voucherCenterService.loadOrderMsgBean(orderNo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderMsgBean>() {
                    @Override
                    public void accept(OrderMsgBean orderMsgBean) throws Exception {
                        iVoucherCenterView.showOrderMsgBean(orderMsgBean);
                    }
                });
    }
}
