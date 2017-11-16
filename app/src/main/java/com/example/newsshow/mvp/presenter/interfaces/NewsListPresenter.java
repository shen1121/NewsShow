package com.example.newsshow.mvp.presenter.interfaces;

/**
 * Created by Administrator on 2017/11/15.
 */

public interface NewsListPresenter extends BasePresenter{

    void setNewsTypeofId(String newsType,String newsId);

    void firstLoadData();

    void refreshData();

    void LoadMoreData();
}
