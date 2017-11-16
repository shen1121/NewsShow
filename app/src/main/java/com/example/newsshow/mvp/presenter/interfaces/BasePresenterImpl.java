package com.example.newsshow.mvp.presenter.interfaces;

import com.example.newsshow.common.RequestCallBack;
import com.example.newsshow.mvp.base.BaseApi;
import com.example.newsshow.mvp.base.BaseView;

import rx.Subscription;

/**
 * Created by Administrator on 2017/11/15.
 */

public class BasePresenterImpl<V extends BaseView, M extends BaseApi, T> implements BasePresenter, RequestCallBack<T> {
    protected V mView;
    protected M mApi;
    protected Subscription subscription;

    public BasePresenterImpl(V rootView, M model) {
        this.mView = rootView;
        this.mApi = model;
    }

    @Override
    public void beforeRequest() {
        if (mView != null) {
            mView.showProgress();
        }

    }

    @Override
    public void success(T data) {
        if (mView != null) {
            mView.hideProgress();
        }
    }

    @Override
    public void onError(String errorMsg) {
        if (mView != null) {
            mView.hideProgress();
            mView.showMsg(errorMsg);
        }

    }

    @Override
    public void onDestory() {
        unSubscript(subscription);
        if (mApi != null) {
            mApi.onDestory();
            this.mApi = null;
        }
        this.mView=null;
        this.subscription=null;

    }

    @Override
    public void onCreat() {

    }

    @Override
    public void unSubscript(Subscription subscription) {
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
