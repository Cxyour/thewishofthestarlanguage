package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.CollectionBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface MyCollectionService {

    @FormUrlEncoded
    @POST("/v1/m/user/my/favorites")
    Observable<CollectionBean> getMyCollection(@Field("loginUserId") int loginUserId, @Field("type") int type);
}
