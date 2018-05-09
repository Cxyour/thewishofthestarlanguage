package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public interface OperationService {
    @FormUrlEncoded
    @POST("/v1/m/homewok/detail")
    Observable<OperationBean> loadOperationBean(@Field("homewokId") int homewokId);

}
