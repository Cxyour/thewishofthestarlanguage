package com.example.lenovo.thewishofthestarlanguage.presenter;

import com.example.lenovo.thewishofthestarlanguage.contact.IPostContract;
import com.example.lenovo.thewishofthestarlanguage.model.biz.PostService;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PostBean;
import com.example.lenovo.thewishofthestarlanguage.model.http.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/10.
 */

public class PostPresenterImp implements IPostContract.IPostPresenter {

    private PostService postService;
    private IPostContract.IPostView iPostView;

    public PostPresenterImp(IPostContract.IPostView iPostView) {
        postService = RetrofitUtils.getInstance().getPostService();
        this.iPostView = iPostView;
    }

    @Override
    public void loadPostBean(int loginUserId) {
        postService.getPostBean(loginUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostBean postBean) {
                        iPostView.showPostBean(postBean.getData().getArtcircleList().getList());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
