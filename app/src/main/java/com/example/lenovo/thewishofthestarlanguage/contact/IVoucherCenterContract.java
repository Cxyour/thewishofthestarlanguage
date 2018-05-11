package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/10.
 */

public interface IVoucherCenterContract {

    interface IVoucherCenterView {
        void showData(VoucherBean voucherBean);
    }

    interface IVoucherCenterPresenter {
        void loadData(int loginUserId);
    }

}
