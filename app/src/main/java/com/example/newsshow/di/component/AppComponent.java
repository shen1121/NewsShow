package com.example.newsshow.di.component;

import android.annotation.TargetApi;
import android.app.Application;

import com.example.newsshow.common.AppManager;

/**
 * Created by Administrator on 2017/11/16.
 */
@javax.inject.Singleton
@TargetApi()
public interface AppComponent {
    Application Application();

    //用于管理所有Activity
    AppManager appManager();

}
