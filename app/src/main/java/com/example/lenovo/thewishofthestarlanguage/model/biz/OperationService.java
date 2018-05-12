package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public interface OperationService {
    @FormUrlEncoded
    @POST("/v1/m/homewok/detail")
    Observable<OperationBean> loadOperationBean(@Field("homewokId") int homewokId);
    //点赞
    @FormUrlEncoded
    @POST("/v1/m/user/praise")
    Observable<GoodOnClickBean> loadGoodBean(@FieldMap Map<String,String> map);
    //取消赞
    @FormUrlEncoded
    @POST("/v1/m/user/praise/cancel")
    Observable<GoodOnClickBean> CancelthePraise(@FieldMap Map<String,String> map);

    //评论回复
    @FormUrlEncoded
    @POST("/v1/m/homewok/comments/save")
    Observable<ReplyBean> loadReplyBean(@FieldMap Map<String,String> map);
}
