package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public interface MostEaveService {
    @FormUrlEncoded
    @POST("/v1/m/homewok/home")
    Observable<MostEavesdeoppBean> loadMostBean(@FieldMap Map<String,Integer> pramas);
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
