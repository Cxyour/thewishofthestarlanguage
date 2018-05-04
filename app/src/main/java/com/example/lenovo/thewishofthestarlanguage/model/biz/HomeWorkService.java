package com.example.lenovo.thewishofthestarlanguage.model.biz;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/4.
 */

public interface HomeWorkService {

    @POST("/v1/m/homewok/home")
    Observable<ResponseBody> getData(@Field("sortord") int sortord);
}
