package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.DouDou;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OrderMsgBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/10.
 */

public interface VoucherCenterService {

    @FormUrlEncoded
    @POST("/v1/m/record/bean/detail")
    Observable<VoucherBean> loadData(@Field("loginUserId") int loginUserId);
    @FormUrlEncoded
    @POST("/v1/m/order/save/recharge")
    Observable<DouDou> loadDouDou(@FieldMap Map<String,String> parmas);

    @FormUrlEncoded
    @POST("/v1/m/alipay/params")
    Observable<OrderMsgBean> loadOrderMsgBean(@Field("orderNo") String orderNo);
}
