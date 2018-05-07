package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public interface PreviewService {
    @POST("/v1/m/forthcoming/home")
    Observable<PreviewBean> loadPreview();
}
