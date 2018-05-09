package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.LovesBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/9.
 */

public interface LovesService {

    @GET("/v1/m/user/preference")
    Observable<LovesBean> getLovesBean();

    @FormUrlEncoded
    @POST("/v1/m/user/my/preference/save")
    Observable<SaveBean> saveLoves(@Field("loginUserId") int userId, @Field("majorIds") List<Integer> majorsIds, @Field("collegeIds") List<Integer> collegesIds);
}
