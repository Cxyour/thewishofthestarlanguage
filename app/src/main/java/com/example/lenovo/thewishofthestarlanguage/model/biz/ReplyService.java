package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyTwoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/11.
 */

public interface ReplyService {

    @FormUrlEncoded
    @POST("/v1/m/homewok/reply")
    Observable<ReplyTwoBean> loadReplyTwoBean(@FieldMap Map<String,String> map);
    //评论回复
    @FormUrlEncoded
    @POST("/v1/m/homewok/comments/save")
    Observable<ReplyBean> loadReplyBean(@FieldMap Map<String,String> map);
}
