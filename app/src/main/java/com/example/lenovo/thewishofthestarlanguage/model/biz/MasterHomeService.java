package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterHomeBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public interface MasterHomeService {
    @FormUrlEncoded
    @POST("/v1/m/user/teacher/homepage")
    Observable<MasterHomeBean> loadMasterHomeBean(@Field("teacherId") int teacherId);
    //点赞
    @FormUrlEncoded
    @POST("/v1/m/user/praise")
    Observable<GoodOnClickBean> loadGoodBean(@FieldMap Map<String,String> map);
    //取消赞
    @FormUrlEncoded
    @POST("/v1/m/user/praise/cancel")
    Observable<GoodOnClickBean> CancelthePraise(@FieldMap Map<String,String> map);
}
