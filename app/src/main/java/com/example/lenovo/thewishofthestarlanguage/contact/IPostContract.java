package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.PostBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/10.
 */

public interface IPostContract {

    interface IPostView {
        void showPostBean(List<PostBean.DataBean.ArtcircleListBean.ListBean> artcircleListBeans);
    }

    interface IPostPresenter {
        void loadPostBean(int loginUserId);
    }

}
