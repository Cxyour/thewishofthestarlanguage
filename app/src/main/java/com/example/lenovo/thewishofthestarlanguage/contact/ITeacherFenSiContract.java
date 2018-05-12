package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TeacherFenSi;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public interface ITeacherFenSiContract {
    interface  view{
        void showTeacherFensi(TeacherFenSi teacherFensi);
    }
    interface  presenter{
        void loadTeacherFensi(int id);
    }
}
