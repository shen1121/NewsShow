package com.example.newsshow.http;

import com.example.newsshow.MyApplication;
import com.example.newsshow.utils.NetWorkUtil;
import com.socks.library.KLog;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/11/16.
 */

public class OkHttpUtil {

public  static  final  long CACHE_MAX_AGE=60*30;
    public  static  final  long CACHE_STALE_SEC=24*24*60;
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    private static final String CACHE_CONTROL_AGE = "max-age="+CACHE_MAX_AGE;

    public static OkHttpUtil getInstance(){
        return new OkHttpUtil();
    }

    public  OkHttpClient getOkHttpClient(){
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
            Request request = chain.request();
            if (!NetWorkUtil.isNetworkAvaiable()){
              request = request.newBuilder()
              .cacheControl(CacheControl.FORCE_CACHE)
              .build();
            }

            Response response = chain.proceed(request);
            if (!NetWorkUtil.isNetworkAvaiable()){
                String cacheControl = request.cacheControl().toString();
                return  response.newBuilder()
                        .header("cacheControl",cacheControl)
                        .removeHeader("parma")
                        .build();
            }else {
                return response.newBuilder()
                        .header("cacheControl",CACHE_CONTROL_CACHE)
                        .removeHeader("param")
                        .build();
            }

        }



    };


   private  final  Interceptor mLoggingInterceptor =new Interceptor() {
       @Override
       public Response intercept(Chain chain) throws IOException {
           Request request = chain.request();
           long t1 = System.nanoTime();
           KLog.i(String.format("Sending request %s on %s%n%s",request.url(),chain.connection(),request.headers()));
           Response response = chain.proceed(request);
           long t2 = System.nanoTime();
           KLog.i(String.format(Locale.getDefault(),"Received response for %s in %.1fms%n%s",
                   response.request().url(),(t2 - t1)/1e6d,response.headers()));
           return response;


       }
   };

/*
  根据网络状况获取缓存策略
 */
   public static  String getCacheControl(){
       return NetWorkUtil.isNetworkAvaiable()?CACHE_CONTROL_AGE:CACHE_CONTROL_CACHE;
   }



}
