package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FollowBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.SaveBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/9.
 */

public interface FollowService {

    @FormUrlEncoded
    @POST("/v1/m/user/personal/homepage/attention")
    Observable<FollowBean> getFollowBean(@Field("studentId") int studentId);

    @FormUrlEncoded
    @POST("/v1/m/user/attention/cancel")
    Observable<SaveBean> abolishConcern(@Field("attentionId") int attentionId, @Field("loginUserId") int loginUserId);

    @FormUrlEncoded
    @POST("/v1/m/user/attention")
    Observable<SaveBean> follow(@Field("attentionId") int attentionId, @Field("loginUserId") int loginUserId);
}
