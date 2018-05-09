package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.FamousTeacherBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;

import java.util.Map;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface IFamousTeacherContract {

    interface IFamousTeacherView{
        void showFamousTecah(FamousTeacherBean famousTeacherBean);
        void  showGoodBean(GoodOnClickBean goodOnClickBean);
        void showCancelthePraise(GoodOnClickBean goodOnClickBean);

    }
    interface IFamousTeacherPresenter{
        void  loadFrmousBean();
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
