package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;

import java.util.Map;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public interface OperationContract {

    interface  view{
        void showOperationBean(OperationBean operationBean);
        void  showGoodBean(GoodOnClickBean goodOnClickBean);
        void showCancelthePraise(GoodOnClickBean goodOnClickBean);
        void  showReplyBean(ReplyBean replyBean);
    }
    interface  presenter{
        void loadOperationBean(int id);
        //取消赞
        void CancelthePraise(Map<String,String> parmas);
        //点赞
        void  loadGoodBean(Map<String,String> parmas);
        void  loadReplyBean(Map<String,String> parmas);
    }
}
