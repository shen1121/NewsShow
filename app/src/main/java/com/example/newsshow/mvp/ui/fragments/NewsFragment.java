package com.example.newsshow.mvp.ui.fragments;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.newsshow.R;
import com.example.newsshow.di.component.AppComponent;
import com.example.newsshow.mvp.presenter.interfaces.NewsListPresenterImpl;
import com.example.newsshow.mvp.ui.fragments.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/16.
 */

public class NewsFragment extends BaseFragment<NewsListPresenterImpl> {
    @Override
    protected void setFragmentComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayputId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {
//        AppBarLayout appBarLayout = getActivity().findViewById(R.id.appBar);
//        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
//        ViewPager viewPager = getActivity().findViewById(R.id.view_pager);
//        ImageView mAddIv = getActivity().findViewById(R.id.add_channel_iv);
//        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
//        FloatingActionButton fb = getActivity().findViewById(R.id.fb);
    }

    @Override
    protected void initData() {

    }
}
