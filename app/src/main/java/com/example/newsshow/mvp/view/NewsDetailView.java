package com.example.newsshow.mvp.view;

import com.example.newsshow.mvp.base.BaseView;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsDetail;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsSummary;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public interface NewsDetailView extends BaseView {

    void showNewsContext(NewsDetail newsDetail);
}
