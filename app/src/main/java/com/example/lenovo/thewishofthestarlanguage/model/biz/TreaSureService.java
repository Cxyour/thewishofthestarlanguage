package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTuBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface TreaSureService {
    @FormUrlEncoded
    @POST("/v1/m/artcircle/home")
    Observable<TreaSureBean> loadTreaSure(@FieldMap Map<String,Integer> map);
    @POST("/v1/m/artcircle/slideshow")
    Observable<TreaSureLunBoTuBean> loadTreaSureLunBoTu();
}
