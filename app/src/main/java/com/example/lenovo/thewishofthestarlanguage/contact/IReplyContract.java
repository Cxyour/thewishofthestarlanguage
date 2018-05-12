package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyTwoBean;

import java.util.Map;

/**
 * Created by 陈伟霆 on 2018/5/11.
 */

public interface IReplyContract {
    interface view{
        void showReplyTwoBean(ReplyTwoBean replyTwoBean);
        void  showReplyBean(ReplyBean replyBean);
    }
    interface  presenter{
        void  loadReplyTwoBean(Map<String,String> map);
        void  loadReplyBean(Map<String,String> parmas);
    }
}
