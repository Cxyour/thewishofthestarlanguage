package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.AppTokenBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2018/5/4.
 */

public interface AppTokenService {

    @POST("/v1/m/security/apptoken")
    Observable<AppTokenBean> getAppToken();
}
