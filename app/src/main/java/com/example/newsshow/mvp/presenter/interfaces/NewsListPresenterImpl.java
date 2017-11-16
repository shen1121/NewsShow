package com.example.newsshow.mvp.presenter.interfaces;

import com.example.newsshow.common.RequestCallBack;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsSummary;
import com.example.newsshow.mvp.model.apis.interfaces.NewsModuleApi;
import com.example.newsshow.mvp.view.NewsListView;

import java.util.List;

import rx.Subscription;

/**
 * Created by Administrator on 2017/11/15.
 */

public class NewsListPresenterImpl extends BasePresenterImpl<NewsListView,NewsModuleApi,List<NewsSummary>>
        implements NewsListPresenter,RequestCallBack<List<NewsSummary>>{



    public NewsListPresenterImpl(NewsListView rootView, NewsModuleApi model) {
        super(rootView, model);
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onCreat() {

    }

    @Override
    public void unSubscript(Subscription subscription) {
        super.unSubscript(subscription);
    }

    @Override
    public void setNewsTypeofId(String newsType, String newsId) {

    }

    @Override
    public void firstLoadData() {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void LoadMoreData() {

    }
}
