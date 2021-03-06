package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewActivityBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface PrevieDetailsService {
    @FormUrlEncoded
    @POST("/v1/m/forthcoming/detail")
    Observable<PreviewActivityBean> loadPreviewActivityBean(@Field("courseId") int courseId);
}
