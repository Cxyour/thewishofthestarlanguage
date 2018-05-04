package com.example.lenovo.thewishofthestarlanguage.model.http;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.lenovo.thewishofthestarlanguage.model.biz.AppTokenService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FamousTeacherService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LoginService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PersonalService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.RegisterService;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.config.Urls;
import com.example.lenovo.thewishofthestarlanguage.model.entity.AppTokenBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Set;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 2018/5/3.
 */

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;
    private SharedPreferences user;

    private RetrofitUtils() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Urls.UNIVSTARURL)
                .client(getOkHttpClient())
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

    public OkHttpClient getOkHttpClient() {
        getToken();
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("apptoken", user.getString("apptoken", null));
                return chain.proceed(builder.build());

            }
        };
        return new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();
    }

    public LoginService getLoginService() {
        return retrofit.create(LoginService.class);
    }

    public RegisterService getRegisterService() {
        return retrofit.create(RegisterService.class);
    }

    public PersonalService getPersonalService() {
        return retrofit.create(PersonalService.class);
    }

    public FamousTeacherService getFamousTeacherService() {
        return retrofit.create(FamousTeacherService.class);
    }

    public AppTokenService getAppTokenService() {
        return retrofit.create(AppTokenService.class);
    }

    public void getToken() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.UNIVSTARURL)
                .build();
        retrofit.create(AppTokenService.class).getAppToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppTokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("1", d.toString());
                    }

                    @Override
                    public void onNext(AppTokenBean appTokenBean) {
                        String appToken = appTokenBean.getData().getApptoken();
                        Log.e("2", appToken);
                        user = App.context.getSharedPreferences("user", 0);
                        SharedPreferences.Editor edit = user.edit();
                        edit.putString("apptoken", appToken);
                        edit.commit();
                    }

                    @Override
                    public void onError(Throwable e) {
//                        Log.e("3",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
