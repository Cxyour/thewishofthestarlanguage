package com.example.lenovo.thewishofthestarlanguage.model.biz;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public interface CurriculumService {
    @FormUrlEncoded
    @POST("/v1/m/user/teacher/live")
    Observable<TaskBean> loadTaskBean(@Field("teacherId") int teacherId);
}
