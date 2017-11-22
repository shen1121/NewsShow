package com.example.newsshow.mvp.ui.activities.base;

import com.example.newsshow.di.component.AppComponent;
import com.example.newsshow.mvp.model.apis.NewsChannelApiImpl;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsChannelTable;

/**
 * Created by Administrator on 2017/11/22.
 */

public class NewsChannleActivity extends BaseActivity<NewsChannelApiImpl> {
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


}
