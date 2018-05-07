package com.example.lenovo.thewishofthestarlanguage.model.biz;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface FindPassWordService {
    @FormUrlEncoded
    @POST("/v1/m/user/authcode")
    Observable<ResponseBody> loadPhoneMSG(@FieldMap Map<String, String> parmas);
    @FormUrlEncoded
    @POST("/v1/m/user/register/mobile")
    Observable<ResponseBody> goToResetPassWord(@FieldMap Map<String, String> parmas);
}
