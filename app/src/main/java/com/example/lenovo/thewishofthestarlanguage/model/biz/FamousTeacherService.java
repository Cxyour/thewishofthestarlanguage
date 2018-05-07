package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface FamousTeacherService {

    @POST("v1/m/home/list")
    Observable<FamousTeacherBean> loadFamousBean();
}
