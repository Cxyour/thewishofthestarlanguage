package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MostEavesdeoppBean;

import java.util.Map;

/**
 * Created by 陈伟霆 on 2018/5/5.
 */

public interface MostEaveContract {
    interface  view{
        void showMostEavesdeopp(MostEavesdeoppBean mostEavesdeoppBean);
        void  showGoodBean(GoodOnClickBean goodOnClickBean);
        void showCancelthePraise(GoodOnClickBean goodOnClickBean);
    }
    interface  presenter{
        void loadMostEavesdeopp(Integer string);
        //点赞
        void  loadGoodBean(Map<String,String> parmas);
        //取消赞
        void CancelthePraise(Map<String,String> parmas);
        //收藏
        void Collection(Map<String,String> parmas);
        //取消收藏
        void  CancelTheCollection(Map<String,String> parmas);
    }
}
