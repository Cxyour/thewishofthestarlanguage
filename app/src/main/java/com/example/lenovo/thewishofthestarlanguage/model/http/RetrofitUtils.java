package com.example.lenovo.thewishofthestarlanguage.model.http;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;

import com.example.lenovo.thewishofthestarlanguage.model.biz.AppTokenService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FamousTeacherService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FansService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FindPassWordService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.FollowService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.HomeWorkService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LiveIngService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LoginService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.LovesService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MasterHomeService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MasterService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MostEaveService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MyOrderService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.OperationService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PerFectInforService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PersonalService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PrevieDetailsService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PreviewService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.RegisterService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.ResetPassWordService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.TreaSureService;
import com.example.lenovo.thewishofthestarlanguage.model.biz.TreasureDetailsServiece;
import com.example.lenovo.thewishofthestarlanguage.model.config.App;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.config.Urls;
import com.example.lenovo.thewishofthestarlanguage.model.entity.AppTokenBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
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
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(15, TimeUnit.SECONDS)//链接超时
//                .readTimeout(20,TimeUnit.SECONDS)//读取
//                .writeTimeout(20,TimeUnit.SECONDS)//写
//                .retryOnConnectionFailure(false)//目前关闭重复请求
                .addInterceptor(new ReceivedCookiesInterceptor(App.context))
                .addInterceptor(new AddCookiesInterceptor(App.context))
                .build();

        if (TextUtils.isEmpty(getAppToken(App.context))) {
            getToken();
        }

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Urls.UNIVSTARURL)
                .client(okHttpClient)
                .build();

        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(App.context, mPermissionList, 123);
        }

    }

    public static String getAppToken(Context context) {
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);

        String apptoken = sharedPreferences.getString(Constant.AppToken, "");
        if (TextUtils.isEmpty(apptoken)) {
            return "";
        }
        //TODU测试id
        return apptoken;

    }

    private void saveAppToken(Context context, String token, long time) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //存储的时候 转成大写后的token + "."  + 加上当前系统时间 组成最中的token
        editor.putString(Constant.AppToken, token + "." + time);
        editor.commit();

    }

    public void getToken() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(new ReceivedCookiesInterceptor(App.context))
                .addInterceptor(new AddCookiesInterceptor(App.context))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Urls.UNIVSTARURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(AppTokenService.class).getAppToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppTokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AppTokenBean appTokenBean) {
                        if (appTokenBean == null || appTokenBean.getData() == null) {
                            return;
                        }

                        String apptoken = appTokenBean.getData().getApptoken();
                        long time = System.currentTimeMillis();
                        try {
                            String desApptoken = EncryptUtil.decrypt(apptoken);//解码后的数据
                            //解码后的数据拼接上当前系统时间 再编码 去掉换行 把所有字母转成大写
                            String headerApptoken = EncryptUtil.encrypt(time + desApptoken).replaceAll("\\n", "").toUpperCase();
                            saveAppToken(App.context, headerApptoken, time);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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

    public PerFectInforService getPerFectInforService() {
        return retrofit.create(PerFectInforService.class);
    }

    public HomeWorkService getHomeWorkService() {
        return retrofit.create(HomeWorkService.class);
    }

    public FindPassWordService getFindPassWordService() {
        return retrofit.create(FindPassWordService.class);
    }

    public ResetPassWordService getResetService() {
        return retrofit.create(ResetPassWordService.class);
    }

    public MostEaveService getMostEaveModel() {
        return retrofit.create(MostEaveService.class);
    }

    public PreviewService getPreviewModel() {
        return retrofit.create(PreviewService.class);
    }

    public TreaSureService getTreaSureService() {
        return retrofit.create(TreaSureService.class);
    }

    public TreasureDetailsServiece getPreviewDetailsServiece() {
        return retrofit.create(TreasureDetailsServiece.class);
    }

    public PrevieDetailsService getPrevieDetailsService() {
        return retrofit.create(PrevieDetailsService.class);
    }

    public FansService getFansService() {
        return retrofit.create(FansService.class);
    }

    public FollowService getFollowService() {
        return retrofit.create(FollowService.class);
    }

    public LiveIngService getLiveIngService() {
        return retrofit.create(LiveIngService.class);
    }

    public LovesService getLovesService() {
        return retrofit.create(LovesService.class);
    }

    public MasterHomeService getMasterHomeService() {
        return retrofit.create(MasterHomeService.class);
    }

    public MasterService getMasterService() {
        return retrofit.create(MasterService.class);
    }

    public MyOrderService getMyOrderService() {
        return retrofit.create(MyOrderService.class);
    }

    public OperationService getOperationService() {
        return retrofit.create(OperationService.class);
    }
}