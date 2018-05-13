package com.example.lenovo.thewishofthestarlanguage.model.biz;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/13.
 */

public interface MessageChangeService {

    @FormUrlEncoded
    @POST("/v1/m/user/info/edit")
    Observable<ResponseBody> messageChange(@Field("user") int user, @FieldMap Map<String, String> paramsMap);
}
