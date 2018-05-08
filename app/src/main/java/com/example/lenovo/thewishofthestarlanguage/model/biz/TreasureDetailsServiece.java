package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TreasurteActiviyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface TreasureDetailsServiece {
    @FormUrlEncoded
    @POST("/v1/m/artcircle/detail")
    Observable<TreasurteActiviyBean> loadPreviewActiviyBean(@Field("artcircleId") int artcircleId);

}
