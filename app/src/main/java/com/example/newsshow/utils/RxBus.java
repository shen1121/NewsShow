package com.example.newsshow.utils;

import android.database.Observable;

import javax.security.auth.Subject;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by Administrator on 2017/11/16.
 */

public class RxBus {



    private static RxBus sRxBus;
    private final rx.subjects.Subject<Object, Object> mBus;

    public RxBus() {
        mBus = new SerializedSubject<>(PublishSubject.create());
    }

    public static  RxBus getInstance(){
        if (sRxBus==null){
            synchronized (RxBus.class){
                if (sRxBus==null){
                    sRxBus = new RxBus();
                }
            }
        }
        return sRxBus;
    }

    // 提供了一个新的事件
    public void post(Object o){
        mBus.onNext(o);
    }

    public <T> rx.Observable<T> tObservable(Class<T> eventof){
        return mBus.ofType(eventof);
    }





}
