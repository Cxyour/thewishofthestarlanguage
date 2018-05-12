package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface ChangePasswordService {

    @FormUrlEncoded
    @POST("/v1/m/user/verify/authcode")
    Observable<SaveBean> isCodeSuccess(@Field("mobile") String mobile, @Field("authCode") String authCode);
}
