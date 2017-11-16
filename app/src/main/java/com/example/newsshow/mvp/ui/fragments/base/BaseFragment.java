package com.example.newsshow.mvp.ui.fragments.base;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsshow.MyApplication;
import com.example.newsshow.di.component.AppComponent;
import com.example.newsshow.mvp.presenter.interfaces.BasePresenter;

import rx.Subscription;

/**
 * Created by Administrator on 2017/11/16.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private  T presenter;

    private final String TAG = "BaseFragment";
    protected View mFragmentView;
   private Subscription subscription;

    protected abstract void setFragmentComponent(AppComponent appComponent);

    protected abstract int getLayputId();

    protected abstract void initView(View view);

    protected abstract void initData();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyApplication application = (MyApplication) getActivity().getApplication();
        setFragmentComponent((AppComponent) application);
        Log.i(TAG, "onActivityCreated");
        initData();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreat");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        if (mFragmentView==null) {
            mFragmentView = inflater.inflate(getLayputId(), container, false);
            initView(mFragmentView);
        }
        return  mFragmentView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription!=null&&subscription.isUnsubscribed()){
            subscription.unsubscribe();
            subscription=null;
        }

        if ( presenter!=null){
            presenter.onDestory();
            presenter=null;
        }

    }
}
