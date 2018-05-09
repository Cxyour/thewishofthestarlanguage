package com.example.lenovo.thewishofthestarlanguage.model.biz;


import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.UpLoadBitmapBean;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by 陈伟霆 on 2018/5/3.
 */

public interface PerFectInforService {
    @FormUrlEncoded
    @POST("/v1/m/user/saveCompleteUser")
    Observable<PerFectInforBean> loadIperFectMsg(@FieldMap Map<String, String> params, @Field("sex") Integer sex);

    @Multipart
    @POST("/v1/m/qiniu/qiniuUpload")
    Observable<UpLoadBitmapBean> uploadImg(@Part List<MultipartBody.Part> file);

}
