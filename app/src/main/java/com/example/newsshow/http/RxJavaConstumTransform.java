package com.example.newsshow.http;

import java.util.Observable;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/11/17.
 */

public class RxJavaConstumTransform {

    public  static  <T> rx.Observable.Transformer<T,T>  defaultSchedulers(){
        return new rx.Observable.Transformer<T, T>() {
            @Override
            public rx.Observable<T> call(rx.Observable<T> tObservable) {
                return tObservable.unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
