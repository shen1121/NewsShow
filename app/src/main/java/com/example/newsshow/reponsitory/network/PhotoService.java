package com.example.newsshow.reponsitory.network;

import android.database.Observable;

import com.example.newsshow.mvp.model.apis.entity.photos.GirlData;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/11/22.
 */

public interface PhotoService {
    @GET("data/福利/{size}/{startPage}")
    Observable<GirlData>getPhotoList(
        @Header("Cache_Control") String cacaheControl,
        @Path("size") int size,
        @Path("startPage") int startPage
    );
}
