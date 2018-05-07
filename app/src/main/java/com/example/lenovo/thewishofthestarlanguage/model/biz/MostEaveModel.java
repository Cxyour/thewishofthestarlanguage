package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public interface MostEaveModel {
    @FormUrlEncoded
    @POST("/v1/m/homewok/home")
    Observable<MostEavesdeoppBean> loadMostBean(@FieldMap Map<String,String> pramas);
}
