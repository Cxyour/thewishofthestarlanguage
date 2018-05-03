package com.example.lenovo.thewishofthestarlanguage.model.http;

import com.example.lenovo.thewishofthestarlanguage.model.biz.LoginService;
import com.example.lenovo.thewishofthestarlanguage.model.config.Urls;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 2018/5/3.
 */

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Urls.UNIVSTARURL)
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public LoginService getLoginService() {
        return retrofit.create(LoginService.class);
    }
}
