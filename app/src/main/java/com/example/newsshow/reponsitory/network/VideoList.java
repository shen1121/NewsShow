package com.example.newsshow.reponsitory.network;

import android.database.Observable;

import com.example.newsshow.mvp.model.apis.entity.videos.VideoData;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/11/22.
 */

public interface VideoList {

    @GET("nc/video/list/{videoType}/n/{startPage}-10.html")
   Observable<Map<String,List<VideoData>>> getVideoList(
           @Header("Cache_Control") String cacheControl,
           @Path("videoType") String videoType,
           @Path("startPage") int startPage
    );

}
