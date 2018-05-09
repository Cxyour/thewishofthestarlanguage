package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LiveDetailsBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LivePurchaseBean;

import java.util.Map;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public interface LiveIngContract {
    interface  view{
        void showLiveBean(LiveDetailsBean liveDetailsBean);
        void showLivePurchaseBean(LivePurchaseBean livePurchaseBean);
        void  showGoodBean(GoodOnClickBean goodOnClickBean);
        void showCancelthePraise(GoodOnClickBean goodOnClickBean);
    }
    interface  presenter{
        void loadLiveBean(String string);
        void loadLivePurchaseBean(int id);
        //收藏
        void Collection(Map<String,String> parmas);
        //取消收藏
        void  CancelTheCollection(Map<String,String> parmas);

    }
}
