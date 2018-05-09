package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LiveDetailsBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LivePurchaseBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public interface LiveIngService {
    @FormUrlEncoded
    @POST("/v1/m/liveCourse/list")
        Observable<LiveDetailsBean> loadLiveBean(@Field("type") String type);
    @FormUrlEncoded
    @POST("/v1/m/liveCourse/detail")
    Observable<LivePurchaseBean> loadLivePurchaseBean(@Field("id")int id);
    //收藏
    @FormUrlEncoded
    @POST("/v1/m/user/favorite")
    Observable<GoodOnClickBean> Collection(@FieldMap Map<String,String> map);
    //取消收藏
    @FormUrlEncoded
    @POST("/v1/m/user/favorite/cancel")
    Observable<GoodOnClickBean>   CancelTheCollection(@FieldMap Map<String,String> map);
}
