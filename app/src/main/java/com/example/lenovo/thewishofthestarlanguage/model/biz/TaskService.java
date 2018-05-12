package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public interface TaskService {
    @FormUrlEncoded
    @POST("/v1/m/user/teacher/homewok")
    Observable<TaskBean> loadTaskBean(@Field("teacherId") int teacherId);
}
