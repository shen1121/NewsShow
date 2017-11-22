package com.example.newsshow.mvp.ui.activities.base;

import com.example.newsshow.di.component.AppComponent;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsDetail;
import com.example.newsshow.mvp.presenter.interfaces.NewsDetailPresenter;
import com.example.newsshow.mvp.view.NewsDetailView;

/**
 * Created by Administrator on 2017/11/22.
 */

public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter>implements NewsDetailView {

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showNewsContext(NewsDetail newsDetail) {

    }
}
