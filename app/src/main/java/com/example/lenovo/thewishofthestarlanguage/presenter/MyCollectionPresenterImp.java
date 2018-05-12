package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IMyCollectionContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.MyCollectionService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.CollectionBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class MyCollectionPresenterImp implements IMyCollectionContract.IMyCollectionPresenter {

    private MyCollectionService myCollectionService;
    private IMyCollectionContract.IMyCollectionView iMyCollectionView;

    public MyCollectionPresenterImp(IMyCollectionContract.IMyCollectionView iMyCollectionView) {
        myCollectionService = RetrofitUtils.getInstance().getMyCollectionService();
        this.iMyCollectionView = iMyCollectionView;
    }

    @Override
    public void loadMyCollectionData(int loginUserId, int type) {
        myCollectionService.getMyCollection(loginUserId, type)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CollectionBean>() {
                    @Override
                    public void accept(CollectionBean collectionBean) throws Exception {
                        iMyCollectionView.showMyCollectionMessage(collectionBean.getData().getList());
                    }
                });
    }
}
