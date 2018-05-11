package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IVoucherCenterContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.VoucherCenterService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

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
}
