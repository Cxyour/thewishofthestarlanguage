package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MyOrderBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/8.
 */

public interface MyOrderService {

    @FormUrlEncoded
    @POST("/v1/m/user/my/orders")
    Observable<MyOrderBean> getMyOrder(@Field("loginUserId") int userId, @Field("status") int status);
}
