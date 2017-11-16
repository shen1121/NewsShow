package com.example.newsshow.mvp.presenter.interfaces;

import rx.Subscription;

/**
 * Created by Administrator on 2017/11/15.
 */

public interface BasePresenter {
    void onDestory();

    void onCreat();

    void unSubscript(Subscription subscription);
}
