package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/4.
 */

public interface ResetPassWordService {

    @FormUrlEncoded
    @POST("/v1/m/user/save/password")
    Observable<UserBean> resetPassWord(@FieldMap Map<String, String> paramsMap);
}
