package com.example.newsshow.http;

import com.example.newsshow.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/11/16.
 */

public class OkhttpUtil {

public  static  final  long CACHE_MAX_AGE=60*30;
    public  static  final  long CACHE_STALE_SEX=24*24*60;

    public static  OkhttpUtil getInstance(){
        return new OkhttpUtil();
    }

    public  OkHttpClient getOkhttpClient(){
        Cache  cache=new Cache(new File(MyApplication.getInstance().getCacheDir().getAbsolutePath(),"OkhttpCache"),
                1024*1024*60);
        return  new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(mLoggingInterceptor)
                .build();

    }

    private  final Interceptor mRewriteCacheControlInterceptor =new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            return null;
        }
    };


   private  final  Interceptor mLoggingInterceptor =new Interceptor() {
       @Override
       public Response intercept(Chain chain) throws IOException {
           return null;
       }
   };



}
