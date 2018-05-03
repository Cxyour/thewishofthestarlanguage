package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface FamousTeacherService {
    @FormUrlEncoded
    @POST("/v1/m/home/alliance/list")
    Observable<FamousTeacherBean> loadFamousBean();
}
