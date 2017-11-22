package com.example.newsshow.reponsitory.network;

import android.database.Observable;

import com.example.newsshow.mvp.model.apis.entity.netease.NewsDetail;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsSummary;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;



/**
 * Created by Administrator on 2017/11/22.
 */

public interface NewsService {

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String,List<NewsSummary>>> getNewsList(
        @Header("Cache-Control") String cacheControl,
        @Path("type") String type,
        @Path("id") String id,
        @Path("startPage") int startPage
    );

    @GET("nc/article/{postId}/full.html")
    Observable<Map<String,NewsDetail>>getNewsDetail(
        @Header("Cache_Control")String CacheControl,
        @Path("postId") String postId
    );

}
