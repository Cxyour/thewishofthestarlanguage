package com.example.lenovo.thewishofthestarlanguage.model.biz;


import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public interface PerFectInforService {
        @FormUrlEncoded
        @POST("/v1/m/user/saveCompleteUser")
        Observable<PerFectInforBean> loadIperFectMsg(@FieldMap Map<String,String> params);
}
