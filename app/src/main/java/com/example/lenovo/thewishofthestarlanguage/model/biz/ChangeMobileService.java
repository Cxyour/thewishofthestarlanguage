package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/12.
 */

public interface ChangeMobileService {

    @FormUrlEncoded
    @POST("/v1/m/user/setting/mobile")
    Observable<SaveBean> changeMobile(@Field("loginUserId") int loginUserId, @Field("mobile") String mobile, @Field("code") String code);
}
