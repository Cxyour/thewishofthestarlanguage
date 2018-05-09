package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface PersonalService {

    @FormUrlEncoded
    @POST("/v1/m/user/my")
    Observable<MyBean> getMyBean(@Field("loginUserId") int loginUserId);
}
