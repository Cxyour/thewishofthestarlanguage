package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.Preview;

/**
 * Created by 陈伟霆 on 2018/5/6.
 */

public interface PreviewContract {
    interface  view{
        void showPreview(Preview preview);
    }
    interface  presenter{
        void loadPreview();
    }
}
