package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.DouDou;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OrderMsgBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;

import java.util.Map;

/**
 * Created by Lenovo on 2018/5/10.
 */

public interface IVoucherCenterContract {

    interface IVoucherCenterView {
        void showData(VoucherBean voucherBean);
        void showDouDou(DouDou douDou);
        void showOrderMsgBean(OrderMsgBean orderMsgBean);
    }

    interface IVoucherCenterPresenter {
        void loadData(int loginUserId);
        void loadDouDou(Map<String,String> pramas);
        void loadOrderMsgBean(String orderNo);

    }

}
