package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.MasterHomeBean;

import java.util.Map;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public interface MasterHomeContract {
    interface  view{
        void showMasterHomeBean(MasterHomeBean masterBean);
        void  showGoodBean(GoodOnClickBean goodOnClickBean);
        void showCancelthePraise(GoodOnClickBean goodOnClickBean);
    }
    interface  presenter{
        void loadMasterHomeBean(int teacherId);
        //点赞
        void  loadGoodBean(Map<String,String> parmas);
        //取消赞
        void CancelthePraise(Map<String,String> parmas);
    }
}
