package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST("v1/m/user/login/mobile")
    Observable<UserBean> getLoginMessage(@FieldMap Map<String, String> paramsMap);
}
