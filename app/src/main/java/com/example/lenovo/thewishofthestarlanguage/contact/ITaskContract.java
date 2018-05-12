package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public interface ITaskContract {
    interface  view{
        void showTaskBean(TaskBean taskBean);

    }
    interface  presenter{
        void loadTaskBean(int id);
    }
}
