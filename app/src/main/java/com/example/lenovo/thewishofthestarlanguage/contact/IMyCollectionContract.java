package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.CollectionBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface IMyCollectionContract {

    interface IMyCollectionView {
        void showMyCollectionMessage(List<CollectionBean.DataBean.ListBean> listBeans);
    }

    interface IMyCollectionPresenter {
        void loadMyCollectionData(int loginUserId, int type);
    }
}
