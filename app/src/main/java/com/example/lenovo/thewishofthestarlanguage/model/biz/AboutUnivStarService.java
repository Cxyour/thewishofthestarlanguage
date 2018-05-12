package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.AboutUnivStarBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface AboutUnivStarService {

    @POST("/v1/m/user/setting/about")
    Observable<AboutUnivStarBean> loadAboutUnivStarMessage();
}
