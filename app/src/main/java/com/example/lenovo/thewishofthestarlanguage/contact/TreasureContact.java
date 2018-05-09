package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTuBean;

import java.util.Map;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface TreasureContact  {
    interface view{
        void showTreSure(TreaSureBean treaSure);
        void showLunbotu(TreaSureLunBoTuBean treaSureLunBoTu);
        void  showGoodBean(GoodOnClickBean goodOnClickBean);
        void showCancelthePraise(GoodOnClickBean goodOnClickBean);
    }
    interface  presenter{
        void loadTreSure(int index);
        void loadLunbotu();
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
