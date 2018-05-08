package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewActivityBean;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface IPreviewDetailsContact {
    interface  view{
        void showPreviewActivityBean(PreviewActivityBean previewActivityBean);
    }
    interface  presenter{
        void loadPreviewActivityBean(int id);
    }
}
