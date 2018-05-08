package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TreasurteActiviyBean;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface IDetailsContract {
    interface  view{
        void showPreviewActiviyBean(TreasurteActiviyBean previewActiviyBean);
    }
    interface  presenter{
        void loadPreviewActiviyBean(int  id);
    }
}
