package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface FamousTeacherService {

    @POST("v1/m/home/list")
    Observable<FamousTeacherBean> loadFamousBean();
    //点赞
    @FormUrlEncoded
    @POST("/v1/m/user/praise")
    Observable<GoodOnClickBean> loadGoodBean(@FieldMap Map<String,String> map);
    //取消赞
    @FormUrlEncoded
    @POST("/v1/m/user/praise/cancel")
    Observable<GoodOnClickBean> CancelthePraise(@FieldMap Map<String,String> map);
    //收藏
    @FormUrlEncoded
    @POST("/v1/m/user/favorite")
    Observable<GoodOnClickBean> Collection(@FieldMap Map<String,String> map);
    //取消收藏
    @FormUrlEncoded
    @POST("/v1/m/user/favorite/cancel")
    Observable<GoodOnClickBean>   CancelTheCollection(@FieldMap Map<String,String> map);
}
