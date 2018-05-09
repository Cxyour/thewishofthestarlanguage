package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public interface MasterService  {
    @FormUrlEncoded
    @POST("/v1/m/user/teacher/list")
    Observable<MasterBean> loadMasterBean(@Field("userType") int userType);
}
